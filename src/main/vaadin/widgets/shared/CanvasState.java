package main.vaadin.widgets.shared;

import com.vaadin.shared.AbstractComponentState;
import item.ItemContainer;

/**
 * Created by Alexey on 17.04.2017.
 */

//this class defined shared state, that will send to all users from server
public class CanvasState extends AbstractComponentState {
    public float canvasWidth = 800;
    public float canvasHeight = 600;

    public ItemContainer itemContainer;
    //it'll need to add after creating Canvas widget
}
