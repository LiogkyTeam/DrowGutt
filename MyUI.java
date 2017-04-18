package my.vaadin;

import javax.servlet.annotation.WebServlet;
import java.util.Optional;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.dnd.DragSourceExtension;
import com.vaadin.event.dnd.DropTargetExtension;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.dnd.DropEffect;
import com.vaadin.shared.ui.dnd.EffectAllowed;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

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
        final GridLayout layout = new GridLayout(7, 9);

        final VerticalLayout layout1 = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Smash dat butt:");

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                layout.addComponent(new Button(new String("Row " + i + ", column " + j)), i, j);
            }
        }


        Label draggableLabel = new Label("You can grab and drag me");
        DragSourceExtension<Label> dragSource = new DragSourceExtension<>(draggableLabel);

        // set the allowed effect
        dragSource.setEffectAllowed(EffectAllowed.MOVE);
        // set the text to transfer
        dragSource.setDataTransferText("hello receiver");

        dragSource.addDragStartListener(event ->
                event.getComponent().addStyleName("dragged")
        );
        dragSource.addDragEndListener(event ->
                event.getComponent().removeStyleName("dragged")
        );

        dragSource.addDragStartListener(event -> {
            dragSource.setDragData(null);
        });
        dragSource.addDragEndListener(event ->{
                dragSource.setDragData(null);
        });

        // make the layout accept drops
        DropTargetExtension<GridLayout> dropTarget = new DropTargetExtension<>(layout);

        // the drop effect must match the allowed effect in the drag source for a successful drop
        dropTarget.setDropEffect(DropEffect.MOVE);

        layout.addComponent(draggableLabel, 0, 0);

        // catch the drops
        dropTarget.addDropListener(event -> {
            // if the drag source is in the same UI as the target
            Optional<AbstractComponent> dragSource1 = event.getDragSourceComponent();
            if (dragSource1.isPresent() && dragSource1.get() instanceof Label) {
                // move the label to the layout
                layout.removeComponent(dragSource1.get());
                layout.addComponent(dragSource1.get(), layout.getCursorX(), layout.getCursorY());

                // get possible transfer data
                String message = event.getDataTransferText();
                Notification.show("DropEvent with data transfer: "+ message);
            }
        });

        Button button = new Button("Click Me");

        layout.addComponent(button, 6, 8);
        setContent(layout);

        button.addClickListener( e -> {
            layout.insertRow(layout.getRows());
            layout.addComponent(new Label("Thanks, it works!"), 0, layout.getRows() - 1);
            setContent(layout1);
        });

        Button button1 = new Button("Now Click Me!");
        layout1.addComponents(name, button1);
        button1.addClickListener( e -> {
            setContent(layout);
        });

    }


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
