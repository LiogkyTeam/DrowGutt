package New;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
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

        tuintw.pencilButton.addClickListener( e -> {


            layout.addComponents(label, sample);
            layout1.addComponent(layout);
        });
        layout1.addComponents(tuintw);
        setContent(layout1);




    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
