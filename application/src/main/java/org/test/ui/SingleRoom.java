/*package org.test.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.*;
import org.test.Canvas;

public class SingleRoom extends VerticalLayout implements View {
    public static final String NAME = "Room";

    public SingleRoom(){
        Canvas canvas = room.getCanvas(ui);

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
        ui.setContent(layout);

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
    public void enter(ViewChangeEvent event) {
    }

}*/
