package org.test.ui;

import com.vaadin.annotations.Push;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.*;
import com.vaadin.*;
import com.vaadin.ui.themes.ValoTheme;
import org.test.Canvas;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

@Theme("demo")
@SuppressWarnings("serial")
@Push
public class UI extends com.vaadin.ui.UI
{
    private static Rooms rooms = new Rooms();

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
        final MenuBar menu = new MenuBar();
        final MenuBar.MenuItem pencil = menu.addItem("Pencil", new ThemeResource( "icons/png/pencil.png") , null);
        final MenuBar.MenuItem size = pencil.addItem("Size",null,null);
        size.addItem("1px",new ThemeResource("icons/1.png"),null);
        size.addItem("2px",new ThemeResource("icons/2.png"),null);
        size.addItem("3px",new ThemeResource("icons/3.png"),null);
        size.addItem("4px",new ThemeResource("icons/4.png"),null);
        layout.addComponents(menu);
        layout1.addComponents(layout, canvas);
        setContent(layout1);
        // Draw a 20x20 filled rectangle with the upper left corner
        // in coordinate 10,10. It will be filled with the default
        // color which is black.
        //canvas.fillRect(10, 10, 20, 20);

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

    @Override
    protected void init(VaadinRequest request) {
        AUTH = new Authentication();

	new Navigator(this, this);
	getNavigator().addView(LoginPage.NAME, LoginPage.class);
	getNavigator().setErrorView(LoginPage.class);

	Page.getCurrent().addUriFragmentChangedListener(new UriFragmentChangedListener() {
		@Override
        	public void uriFragmentChanged(UriFragmentChangedEvent event) {
                 	router(event.getUriFragment());
	        }
	});

	router("");
    }
}
