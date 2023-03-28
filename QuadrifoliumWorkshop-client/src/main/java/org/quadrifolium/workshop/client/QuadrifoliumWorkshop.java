package org.quadrifolium.workshop.client;

import org.quadrifolium.workshop.client.gin.QuadrifoliumGinjector;
import org.quadrifolium.workshop.client.global.QuadrifoliumSupervisor;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumAppPresenter;
import org.quadrifolium.workshop.client.ui.QuadrifoliumResources;

import com.allen_sauer.gwt.log.client.Log;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class QuadrifoliumWorkshop implements EntryPoint 
{
	private final QuadrifoliumGinjector injector = GWT.create(QuadrifoliumGinjector.class);

	public void onModuleLoad() 
	{
		Log.info("onModuleLoad") ;

		String sLocale  = Window.Location.getParameter("locale") ;
		String sConcept = Window.Location.getParameter("concept") ;
		if (null != sConcept)
			Log.info("concept parameter detected") ;

		QuadrifoliumResources.INSTANCE.css().ensureInjected() ;

		final QuadrifoliumSupervisor supervisor = injector.getSupervisor() ;

		supervisor.setInjector(injector) ;
		final QuadrifoliumAppPresenter appPresenter = injector.getAppPresenter() ;

		appPresenter.go(RootPanel.get(), sConcept, sLocale) ;
	}
}
