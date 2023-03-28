package org.quadrifolium.workshop.client.gin;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.gin.AbstractPresenterModule;

import org.quadrifolium.client.widgets.FlexTextBox;

import org.quadrifolium.workshop.client.CachingDispatchAsync;
import org.quadrifolium.workshop.client.global.QuadrifoliumSupervisor;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumAppPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumAtelierPhpPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumAtelierPhpView;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumCommandPanelPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumCommandPanelView;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumLoginHeaderPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumLoginHeaderView;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumMainPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumMainView;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumPostLoginHeaderPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumPostLoginHeaderView;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumRegisterPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumRegisterView;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumWelcomePagePresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumWelcomePageView;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumWelcomeTextPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumWelcomeTextView;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumDefinitionsPresenter;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumDefinitionsView;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumLemmasPresenter;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumLemmasView;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumSemanticsPresenter;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumSemanticsView;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumStemmaPresenter;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumStemmaView;

import com.google.inject.Singleton;

public class QuadrifoliumClientModule extends AbstractPresenterModule 
{
	@Override
	protected void configure() 
	{		
		bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class) ;
		
		bindPresenter(QuadrifoliumMainPresenter.class,            QuadrifoliumMainPresenter.Display.class,            QuadrifoliumMainView.class) ;		
		bindPresenter(QuadrifoliumWelcomeTextPresenter.class,     QuadrifoliumWelcomeTextPresenter.Display.class,     QuadrifoliumWelcomeTextView.class) ;
		bindPresenter(QuadrifoliumWelcomePagePresenter.class,     QuadrifoliumWelcomePagePresenter.Display.class,     QuadrifoliumWelcomePageView.class) ;
		bindPresenter(QuadrifoliumLoginHeaderPresenter.class,     QuadrifoliumLoginHeaderPresenter.Display.class,     QuadrifoliumLoginHeaderView.class) ;
		bindPresenter(QuadrifoliumCommandPanelPresenter.class,    QuadrifoliumCommandPanelPresenter.Display.class,    QuadrifoliumCommandPanelView.class) ;
		bindPresenter(QuadrifoliumPostLoginHeaderPresenter.class, QuadrifoliumPostLoginHeaderPresenter.Display.class, QuadrifoliumPostLoginHeaderView.class) ;
		bindPresenter(QuadrifoliumAtelierPhpPresenter.class,      QuadrifoliumAtelierPhpPresenter.Display.class,      QuadrifoliumAtelierPhpView.class) ;
		// bindPresenter(QuadrifoliumLoginResponsePresenter.class,   QuadrifoliumLoginResponsePresenter.Display.class,   QuadrifoliumLoginResponseView.class) ;
		bindPresenter(QuadrifoliumRegisterPresenter.class,        QuadrifoliumRegisterPresenter.Display.class,        QuadrifoliumRegisterView.class) ;
		
		// bindPresenter(QuadrifoliumWorkshopPresenter.class,        QuadrifoliumWorkshopPresenter.Display.class,        QuadrifoliumWorkshopView.class) ;
		bindPresenter(QuadrifoliumLemmasPresenter.class,          QuadrifoliumLemmasPresenter.Display.class,          QuadrifoliumLemmasView.class) ;
		bindPresenter(QuadrifoliumSemanticsPresenter.class,       QuadrifoliumSemanticsPresenter.Display.class,       QuadrifoliumSemanticsView.class) ;
		bindPresenter(QuadrifoliumDefinitionsPresenter.class,     QuadrifoliumDefinitionsPresenter.Display.class,     QuadrifoliumDefinitionsView.class) ;
		bindPresenter(QuadrifoliumStemmaPresenter.class,          QuadrifoliumStemmaPresenter.Display.class,          QuadrifoliumStemmaView.class) ;
		
		bind(QuadrifoliumAppPresenter.class).in(Singleton.class) ;
		bind(QuadrifoliumSupervisor.class).in(Singleton.class) ;
		bind(FlexTextBox.class) ;
		bind(CachingDispatchAsync.class) ;		
	}
}
