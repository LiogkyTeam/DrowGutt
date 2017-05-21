package org.test.ui;

import com.vaadin.shared.MouseEventDetails;
import org.test.Canvas;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.VerticalLayout;

@Theme("demo")
@SuppressWarnings("serial")
public class UI extends com.vaadin.ui.UI
{
    private Canvas canvas;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = UI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        setContent(content);

        // Instantiate the component and add it to your ui
        content.addComponent(canvas = new Canvas());

        // Draw a 20x20 filled rectangle with the upper left corner
        // in coordinate 10,10. It will be filled with the default
        // color which is black.
        canvas.fillRect(10, 10, 20, 20);

        canvas.addMouseMoveListener((MouseEventDetails mouseDetails) -> {
            System.out.println("Mouse moved at "
                    + mouseDetails.getClientX() + ","
                    + mouseDetails.getClientY());
        });

        canvas.addMouseDownListener((MouseEventDetails mouseDetails) -> {
            System.out.println("Mouse down at "
                    + mouseDetails.getClientX() + ","
                    + mouseDetails.getClientY());
        });

        canvas.addMouseUpListener((MouseEventDetails mouseDetails) -> {
            System.out.println("Mouse up at "
                    + mouseDetails.getClientX() + ","
                    + mouseDetails.getClientY());
        });
    }
}
