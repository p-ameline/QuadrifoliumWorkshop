package org.quadrifolium.workshop.client.event;

import org.quadrifolium.workshop.client.mvp.QuadrifoliumWorkshopPresenterModel;
import org.quadrifolium.workshop.client.mvp.QuadrifoliumWorkshopViewModel;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Panel;

/**
 * Message sent when a workshop wants to enroll a lemma management component
 * 
 * @author Philippe
 *
 */
public class GoToWorkshopLemmaEvent extends GwtEvent<GoToWorkshopLemmaEventHandler>
{
	public static Type<GoToWorkshopLemmaEventHandler> TYPE = new Type<GoToWorkshopLemmaEventHandler>() ;

	private GoToWorkshopComponentContent _content = new GoToWorkshopComponentContent() ;

	public static Type<GoToWorkshopLemmaEventHandler> getType() 
	{
		if (null == TYPE)
			TYPE = new Type<GoToWorkshopLemmaEventHandler>() ;
		return TYPE ;
	}

	public GoToWorkshopLemmaEvent(QuadrifoliumWorkshopPresenterModel<QuadrifoliumWorkshopViewModel> parent, Panel workspace) 
	{	
		_content.setWorkspace(workspace) ;
		_content.setParent(parent) ;
	}

	public GoToWorkshopComponentContent getContent() {
		return _content ;
	}

	public Panel getWorkspace() {
		return _content.getWorkspace() ;
	}

	public QuadrifoliumWorkshopPresenterModel<QuadrifoliumWorkshopViewModel> getParent() {
		return _content.getParent() ;
	}

	@Override
	protected void dispatch(GoToWorkshopLemmaEventHandler handler) {
		handler.onGoToWorkshopLemma(this) ;
	}

	@Override
	public Type<GoToWorkshopLemmaEventHandler> getAssociatedType() {
		return TYPE;
	}
}
