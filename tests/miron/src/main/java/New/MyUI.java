package New;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.MouseEvents;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.*;
import com.vaadin.shared.Position;
import com.vaadin.ui.*;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import sun.font.FontAccess;
import com.vaadin.ui.Button.ClickEvent;

import java.awt.*;
import java.awt.Button;
import java.lang.Object;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final VerticalLayout layout = new VerticalLayout();
        final HorizontalLayout layout1 = new HorizontalLayout();
        final TopUiInTheWorld tuintw = new TopUiInTheWorld();
        final Label label = new Label("This Needs to be Colored");
        label.addStyleName("coloredlabel");
        final com.vaadin.ui.Button pencilButton = new com.vaadin.ui.Button();
        final com.vaadin.ui.Button rectangleButton = new com.vaadin.ui.Button();

// Some UI logic to change CSS
        final ColorPicker sample = new ColorPicker("Set the Color Here");
        //sample = new ColorPicker();
        sample.setSwatchesVisibility(false);
        sample.setHistoryVisibility(false);
        sample.setTextfieldVisibility(false);
        sample.setHSVVisibility(false);

        sample.addValueChangeListener(event -> Notification.show(
                "Color changed: " + event.getValue().getCSS()
        ));



        final com.vaadin.ui.Button button = new com.vaadin.ui.Button("Do not press this button");

        button.addClickListener( e-> {
             {
                // Notification.show("Do not press this button again");
            }
        });



        pencilButton.addClickListener( e -> {


            layout.addComponents(label, sample);
            layout1.addComponent(layout);
        });

        layout1.addComponents(pencilButton);
        setContent(layout1);



       /* final HorizontalLayout layout1 = new HorizontalLayout();
        final MenuBar menu = new MenuBar();
        final Label label = new Label("This Needs to be Colored");
        final MenuBar.MenuItem pencil = menu.addItem("Pencil", FontAwesome.PENCIL, null);
        final MenuBar.MenuItem size = pencil.addItem("Size",null,null);
        size.addItem("1", null);//new ThemeResource("1"), null);
        layout1.addComponents(menu, label);
        setContent(layout1);
*/

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
