package org.quadrifolium.workshop.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface RegisterSentEventHandler extends EventHandler 
{
	void onRegisterSend(RegisterSentEvent event) ;
}