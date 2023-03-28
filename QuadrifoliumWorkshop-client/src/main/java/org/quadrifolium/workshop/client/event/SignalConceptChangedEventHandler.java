package org.quadrifolium.workshop.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface SignalConceptChangedEventHandler extends EventHandler 
{
	void onConceptChanged(SignalConceptChangedEvent event) ;
}