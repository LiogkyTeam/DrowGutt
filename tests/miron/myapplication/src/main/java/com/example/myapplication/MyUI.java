package com.example.myapplication;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	private Form form = new Form(this);

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	final VerticalLayout layout = new VerticalLayout();
        
        final TextField name1 = new TextField();
        name1.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks " + name1.getValue() 
                    + ", it works!"));
        });
        
        
        
        
    	final TextField name = new TextField();
        name.setCaption("DO IT!");
    	Button doIt = new Button ("Do it!");
    	
    	doIt.addClickListener(e -> {
    		layout.addComponent(form);
    	});
    	layout.addComponents(name1, button, name, doIt);
    	setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
