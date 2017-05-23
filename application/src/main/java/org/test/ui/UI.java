package org.test.ui;


import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.*;
import com.vaadin.ui.components.colorpicker.ColorChangeEvent;
import com.vaadin.ui.components.colorpicker.ColorChangeListener;
import org.test.Canvas;

import javax.servlet.annotation.WebServlet;


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
        class Info1 {
           private int thickness1;
           private String color;
        }
        Canvas canvas = room.getCanvas(this);

        canvas.setCanvSizes(1000, 570);

        Info1 info = new Info1();
        info.color = "#000000";
        info.thickness1 = 1;
        final VerticalLayout layout = new VerticalLayout();
        final HorizontalLayout layout1 = new HorizontalLayout();
        final HorizontalLayout layout2 = new HorizontalLayout();
        final VerticalLayout layout3 = new VerticalLayout();
        final Button rectangle = new Button("Rectangle", new ThemeResource("icons/png/thin-square.png"));
        rectangle.addStyleName("mystyle");
        rectangle.addClickListener(clickEvent -> {
            canvas.endDraw();
            canvas.startDrawRectangles(info.color,info.thickness1);
        });
        final Button line = new Button("Linear", new ThemeResource("icons/1.png"));
        line.addStyleName("mystyle");
        line.addClickListener(clickEvent -> {
            canvas.endDraw();
            canvas.startDrawLines(info.color,info.thickness1);
        });
        final MenuBar menu = new MenuBar();
        final Label selection = new Label("The thickness is 1 px");
        final Label color = new Label("The color is #ffffff");
        layout1.addComponent(selection);
        selection.addStyleName("labelstyle");
        final MenuBar.Command chooseThickness = new MenuBar.Command() {
            MenuBar.MenuItem previous = null;
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                if (selectedItem.getText().equalsIgnoreCase("1 px")) {
                    info.thickness1 = 1;
                }
                if (selectedItem.getText().equalsIgnoreCase("2 px"))  {
                    info.thickness1 = 2;
                }
                if (selectedItem.getText().equalsIgnoreCase("3 px"))  {
                    info.thickness1 = 3;
                }
                if (selectedItem.getText().equalsIgnoreCase("4 px"))  {
                    info.thickness1 = 4;
                }
                selection.setValue("   The thickness is " + selectedItem.getText());
                if (previous != null)
                    previous.setStyleName(null);
                selectedItem.setStyleName("highlight");
                previous = selectedItem;
            }
        };
        final MenuBar.MenuItem thickness = menu.addItem("Thickness", new ThemeResource( "icons/png/pencil.png") , null);
        final MenuBar.MenuItem size = thickness.addItem("Size",null,null);
        size.addItem("1px",new ThemeResource("icons/1.png"), chooseThickness );
        size.addItem("2px",new ThemeResource("icons/2.png"), chooseThickness);
        size.addItem("3px",new ThemeResource("icons/3.png"), chooseThickness);
        size.addItem("4px",new ThemeResource("icons/4.png"), chooseThickness);
        menu.addStyleName("mystyle");
        ColorPicker picker = new ColorPicker("Pick the color");
        picker.addColorChangeListener(new ColorChangeListener() {
            @Override
            public void colorChanged(ColorChangeEvent event) {
                // Do something with the color
                color.setValue(
                        "Color is " + event.getColor().getCSS());
                info.color = event.getColor().getCSS();
                info.color = info.color.substring(1);
            }
        });

        picker.setPosition(
                Page.getCurrent().getBrowserWindowWidth() / 2 - 246/2,
                Page.getCurrent().getBrowserWindowHeight() / 2 - 507/2);
        color.addStyleName("labelstyle");

        picker.addStyleName("mystyle");
        layout3.addComponents(selection, color);
        layout1.addComponents(rectangle, line, menu, picker);
        layout1.setSpacing(true);
        layout2.addComponents(canvas, layout3);
        layout.addComponents(layout1, layout2);
        layout.setSpacing(true);
        setContent(layout);

        /*canvas.addMouseMoveListener((MouseEventDetails mouseDetails) -> {
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
        });*/
    }
}
