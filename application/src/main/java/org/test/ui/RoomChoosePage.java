package org.test.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;

public class RoomChoosePage extends VerticalLayout implements View {
	public static final String NAME = "RoomChoose";

	public RoomChoosePage(){
		// add panel to the layout
		Panel panel = new Panel("Choose a Room");
		panel.setSizeUndefined();
		addComponent(panel);
		
		// add layout with room number and room password fields
		FormLayout content = new FormLayout(); /* FormLayout lays the components and their captions out in two columns */
		TextField roomno = new TextField("Room Number");
		content.addComponent(roomno);
		PasswordField password = new PasswordField("Room Password");
		content.addComponent(password);
		
		// add button for sending credentials
		Button send = new Button("Enter the Room");
        /*
        Entering a room will be fixed soon
        
		send.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				if(VaadinloginUI.AUTH.authenticate(username.getValue(), password.getValue())) {
					VaadinSession.getCurrent().setAttribute("user", username.getValue());
					getUI().getNavigator().addView(SecurePage.NAME, SecurePage.class);
					getUI().getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
					Page.getCurrent().setUriFragment("!"+SecurePage.NAME);
				} else {
					Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
				}
			}
		});
        */
		content.addComponent(send);
		content.setSizeUndefined();
		content.setMargin(true);
		panel.setContent(content);
		setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
	}

}
