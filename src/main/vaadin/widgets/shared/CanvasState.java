package main.vaadin.widgets.shared;

import com.vaadin.shared.AbstractComponentState;
import item.Item;
import item.ItemContainer;

import java.util.List;
import java.util.Map;

//this class defined shared state, that will send to all users from server
public class CanvasState extends AbstractComponentState {
    public float canvasWidth = 800;
    public float canvasHeight = 600;

    public ItemContainer itemContainer;
    //it'll need to add after creating Canvas widget
}
