package org.test.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;

public class LoginPage extends VerticalLayout implements View {
	public static final String NAME = "";

	public LoginPage(){
		// add login panel to the layout
		Panel panel = new Panel("Login");
		panel.setSizeUndefined();
		addComponent(panel);
		
		// add layout with username and password fields
		FormLayout content = new FormLayout(); /* FormLayout lays the components and their captions out in two columns */
		TextField username = new TextField("Username");
		content.addComponent(username);
		PasswordField password = new PasswordField("Password");
		content.addComponent(password);
		
		// add button for sending credentials
		Button send = new Button("Enter");
		send.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				if(UI.AUTH.authenticate(username.getValue(), password.getValue())) {
					VaadinSession.getCurrent().setAttribute("user", username.getValue());
					getUI().getNavigator().addView(RoomChoosePage.NAME, RoomChoosePage.class);
					Page.getCurrent().setUriFragment("!"+RoomChoosePage.NAME);
				} else {
					Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
				}
			}
		});
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
