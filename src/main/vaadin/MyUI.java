package main.vaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
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

    //private CustomerService service = CustomerService.getInstance();
    //private Grid<Customer> grid = new Grid<>(Customer.class);
    //private TextField filterText = new TextField();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);

        Label label = new Label("Some text add");
        layout.addComponent(label);
        Label label1 = new Label("New Some text");
        layout.addComponent(label1);

        Button clearTextFldBtn = new Button(VaadinIcons.CLOSE);
        clearTextFldBtn.setDescription("Clear");


        Button rep = new Button("New repository");
        rep.addClickListener(e -> {layout.addComponent(new Label("Thanks for press")); });
        layout.addComponents(clearTextFldBtn, rep);
        setContent(layout);

        /*filterText.addValueChangeListener(e -> grid.setItems(service.findAll(filterText.getValue())));
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.setPlaceholder("filter by name...");

        Button clearTextFldBtn = new Button(VaadinIcons.CLOSE);
        clearTextFldBtn.setDescription("clear");
        clearTextFldBtn.addClickListener(e -> filterText.clear());

        //HorizontalLayout filtering = new HorizontalLayout();
        //filtering.setSpacing(true);
        CssLayout filtering = new CssLayout();
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        filtering.addComponents(filterText, clearTextFldBtn);

        grid.setColumns("id", "firstName", "lastName", "email");
        updateList();

        layout.addComponents(filtering, grid);*/

    }

   /* public void updateList(){
        List<Customer> customers = service.findAll();
        grid.setItems(customers);
    }*/

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}