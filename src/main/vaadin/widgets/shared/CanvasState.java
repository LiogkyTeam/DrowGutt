package main.vaadin.widgets.shared;

import com.vaadin.shared.AbstractComponentState;

import java.util.Map;

/**
 * Created by Alexey on 17.04.2017.
 */
//this class defined shared state, that will send to all users from server
public class CanvasState extends AbstractComponentState {
    public float canvasWidth = 800;
    public float canvasHeight = 600;

    //public Map<Item, Type> items
    //it'll need to add after creating Canvas widget
}
