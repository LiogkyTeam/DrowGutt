package org.test.ui;


import com.vaadin.annotations.Push;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.*;
import com.vaadin.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;
import org.test.Canvas;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

import java.awt.*;

@Theme("demo")
@SuppressWarnings("serial")
@Push
public class UI extends com.vaadin.ui.UI
{
    private static Rooms rooms = Rooms.getInstance();

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = UI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        Key<String> name = new Key<String>("MyRoom_v0.01");
        Room room;
        try {
            room = rooms.createRoom(name, 0, getUI());
        } catch(NonUniqName e) {
            //some handling
            return;
        }

        Canvas canvas = room.getCanvas(this);

        final VerticalLayout layout = new VerticalLayout();
        final HorizontalLayout layout1 = new HorizontalLayout();
        final Button rectangle = new Button("Rectangle", new ThemeResource("icons/png/thin-square.png"));
        rectangle.addStyleName("mystyle");
        //rectangle.addClickListener(clickEvent -> Notification.show ("Norm"));
        final Button line = new Button("Linear", new ThemeResource("icons/1.png"));
        line.addStyleName("mystyle");
        line.addClickListener(clickEvent -> {canvas.startDrawLines("", 2);});
        layout1.addComponents(rectangle, line);
        layout1.setSpacing(true);
        layout.addComponents(layout1, canvas);
        layout.setSpacing(true);
        setContent(layout);

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
