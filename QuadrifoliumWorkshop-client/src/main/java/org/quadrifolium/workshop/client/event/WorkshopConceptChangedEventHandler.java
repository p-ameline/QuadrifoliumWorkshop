package org.quadrifolium.workshop.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface WorkshopConceptChangedEventHandler extends EventHandler 
{
	void onWorkshopConceptChanged(WorkshopConceptChangedEvent event) ;
}