package org.quadrifolium.workshop.client.gin;

import net.customware.gwt.dispatch.client.gin.StandardDispatchModule;

import org.quadrifolium.client.widgets.FlexTextBox;

import org.quadrifolium.workshop.client.global.QuadrifoliumSupervisor;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumAppPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumAtelierPhpPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumCommandPanelPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumLoginHeaderPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumPostLoginHeaderPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumRegisterPresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumWelcomePagePresenter;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumWelcomeTextPresenter;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumDefinitionsPresenter;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumLemmasPresenter;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumSemanticsPresenter;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumStemmaPresenter;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * The injector is in charge of delivering objects, either by creating them or, if singletons, by passing current instances 
 * 
 * @author Philippe
 *
 */
@GinModules({ StandardDispatchModule.class, QuadrifoliumClientModule.class })
public interface QuadrifoliumGinjector extends Ginjector 
{
	QuadrifoliumSupervisor               getSupervisor() ;

	QuadrifoliumAppPresenter             getAppPresenter() ;

	QuadrifoliumLoginHeaderPresenter     getLoginPresenter() ;	
	// QuadrifoliumLoginResponsePresenter   getLoginResponsePresenter() ;
	QuadrifoliumPostLoginHeaderPresenter getPostLoginHeaderPresenter() ;
	
	QuadrifoliumCommandPanelPresenter    getCommandPresenter() ;
	
	QuadrifoliumWelcomeTextPresenter     getWelcomeTextPresenter() ;
	QuadrifoliumWelcomePagePresenter     getWelcomePagePresenter() ;
	QuadrifoliumAtelierPhpPresenter      getAtelierPhpPresenter() ;
	// QuadrifoliumWorkshopPresenter        getWorkshopPresenter() ;
	
	QuadrifoliumLemmasPresenter          getLemmasPresenter() ;
	QuadrifoliumSemanticsPresenter       getSemanticsPresenter() ;
	QuadrifoliumDefinitionsPresenter     getDefinitionsPresenter() ;
	QuadrifoliumStemmaPresenter          getStemmaPresenter() ;
	
	QuadrifoliumRegisterPresenter        getRegisterPresenter() ;
	
	FlexTextBox                          getFlexTextBox() ;
}
