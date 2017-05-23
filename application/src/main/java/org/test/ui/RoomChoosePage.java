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
		TextField roomName = new TextField("Room Name");
		content.addComponent(roomName);
		PasswordField password = new PasswordField("Room Password");
		content.addComponent(password);
		
		// add button for sending credentials
		Button send = new Button("Enter the Room");
		
		send.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Room room;
					
				try {
					room = Rooms.enterTheRoom(roomName.getValue(), password.getValue(), getUI())
				} catch (RoomNotExists rne) {
					Notification.show("Room with this name doesn't exist", Notification.Type.ERROR_MESSAGE);
				} catch (WrongPassword wp) {
					Notification.show("Wrong password", Notification.Type.ERROR_MESSAGE);
				}
				getUI().setRoom(room);
			}
		});
		
		content.addComponent(send);
		content.setSizeUndefined();
		content.setMargin(true);
		panel.setContent(content);
		setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
		
		
		
		// add panel2 to the layout
		Panel panel2 = new Panel("Create a Room");
		panel2.setSizeUndefined();
		addComponent(panel2);
		
		// add layout with room number and room password fields
		FormLayout content2 = new FormLayout(); /* FormLayout lays the components and their captions out in two columns */
		TextField roomName2 = new TextField("Room Name");
		content2.addComponent(roomName2);
		PasswordField password2 = new PasswordField("Room Password");
		content2.addComponent(password2);
		
		// add button for sending credentials
		Button send2 = new Button("Create a Room");
		
		send2.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Room room;
				
				try {
					room = Rooms.createRoom(roomName2.getValue(), password2.getValue(), getUI())
				} catch (NonUniqName nun) {
					Notification.show("Room with this name already exists", Notification.Type.ERROR_MESSAGE);
				}
				getUI().setRoom(room);
			}
		});
		
		content2.addComponent(send2);
		content2.setSizeUndefined();
		content2.setMargin(true);
		panel2.setContent(content2);
		setComponentAlignment(panel2, Alignment.MIDDLE_CENTER);
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
	}

}
