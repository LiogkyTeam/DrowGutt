package main.vaadin;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */

public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final GridLayout layout = new GridLayout(7, 9);

        final VerticalLayout layout1 = new VerticalLayout();

        final TextField name = new TextField();
        name.setCaption("Smash dat butt:");

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                layout.addComponent(new Button(new String("Row " + i + ", column " + j)), i, j);
            }
        }
        setContent(layout);

    }


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
