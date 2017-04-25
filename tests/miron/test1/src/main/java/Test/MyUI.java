package Test;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.*;
import com.vaadin.ui.*;

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
        final Label label = new Label("This Needs to be Colored");
        label.addStyleName("coloredlabel");
        final com.vaadin.ui.Button pencilButton = new com.vaadin.ui.Button("Pencil");
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
        pencilButton.setIcon(new ThemeResource("icons/1.png"));

        final com.vaadin.ui.Button button = new com.vaadin.ui.Button("Do not press this button");

        button.addClickListener( e-> {
            {
                 Notification.show("Do not press this button again");
            }
        });



        pencilButton.addClickListener( e -> {


            layout.addComponents(label, sample);
            layout1.addComponent(layout);
        });




        final HorizontalLayout layout2 = new HorizontalLayout();
        final MenuBar menu = new MenuBar();
        final MenuBar.MenuItem pencil = menu.addItem("Pencil", VaadinIcons.PENCIL, null);
        final MenuBar.MenuItem size = pencil.addItem("Size",null,null);
        size.addItem("1px",new ThemeResource("icons/1.png"),null);
        size.addItem("2px",new ThemeResource("icons/2.png"),null);
        size.addItem("3px",new ThemeResource("icons/3.png"),null);
        size.addItem("4px",new ThemeResource("icons/4.png"),null);
        PasswordField tf = new PasswordField("Password");
        TextField tf1 = new TextField("Login");
        Button ok = new Button("OK", event ->
        {
            layout.addComponent(new Label("login: " + tf1.getValue()));
            layout.addComponent(new Label("password: " + tf.getValue()));
        });
        layout.addComponents(menu,pencilButton);
        layout.addComponents(button,tf1,tf,ok);
        layout1.addComponents(layout);
        setContent(layout1);



    }



    /*

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
     */




    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
