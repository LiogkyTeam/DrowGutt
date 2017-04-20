package main.vaadin.widgets.client;

/**
 * Created by Степан on 18.04.2017.
 */
import item.Item;

public class DrPoint extends Item {
    private static final long serialVersionUID = 1L;

    protected float x, y;

    public DrPoint() {

    }

    public DrPoint(float x, float y) {
        this.setX_max(x);
        this.setX_min(x);
        this.x = x;
        this.setY_max(y);
        this.setY_min(y);
        this.y = y;
    }
}
