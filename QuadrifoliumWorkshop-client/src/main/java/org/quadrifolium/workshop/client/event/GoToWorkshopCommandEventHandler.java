package org.quadrifolium.workshop.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface GoToWorkshopCommandEventHandler extends EventHandler 
{
	void onGoToWorkshopCommand(GoToWorkshopCommandEvent event) ;
}