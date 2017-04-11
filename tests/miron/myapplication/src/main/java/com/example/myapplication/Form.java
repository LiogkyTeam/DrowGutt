package com.example.myapplication;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.*;
import com.vaadin.ui.DateField;;

public class Form extends FormLayout {
	private TextField firstName = new TextField("First name");
	private TextField lastName = new TextField("Last name");
	private TextField email = new TextField("Email");
	private DateField birthDate = new DateField("Birth date");
	private Button save = new Button("Save");
	private Button delete = new Button("Delete");	
	
	private CustomerService service = CustomerService.getInstance();
	private Customer customer;
	private MyUI myUI;
	
	public Form (MyUI myUI){
		this.myUI = myUI;
		
		setSizeUndefined();
		HorizontalLayout buttons = new HorizontalLayout(save, delete);
		buttons.setSpacing(true);
		addComponents(firstName, lastName, email, birthDate, buttons);
	}
}
