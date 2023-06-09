package org.quadrifolium.workshop.client.mvp_components;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.ButtonBase;

import net.customware.gwt.presenter.client.widget.WidgetDisplay;

public interface QuadrifoliumComponentInterface extends WidgetDisplay
{
	public HasClickHandlers      getEditButtonKeyDown() ;
	public HasClickHandlers      getAddButtonKeyDown() ;
	public ArrayList<ButtonBase> getButtonsArray() ;
	
	public void                  openAddPanel() ;
	public void                  closeAddPanel() ;
	public HasClickHandlers      getAddOkButtonKeyDown() ;
	public HasClickHandlers      getAddCancelButtonKeyDown() ;
	
	public void                  openErrDialogBox(final String sErrMsgId) ;
	public void                  closeErrDialogBox() ;
	public HasClickHandlers      getErrDialogBoxOkButton() ;
}
