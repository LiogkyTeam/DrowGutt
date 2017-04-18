package main.vaadin.widgets.client;

/**
 * Created by Степан on 18.04.2017.
 */
import item.Item;

public class DrPoint extends Item {
    private static final long serialVersionUID = 1L;

    public float x, y;

    public DrPoint() {

    }

    public DrPoint(float x, float y) {
        this.x_max = this.x_min =  this.x = x;
        this.y_max = this.y_min =  this.y = y;
    }
}
