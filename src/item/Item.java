package item;

import java.io.Serializable;

/**
 * Created by Alexey on 02.04.2017.
 */
public class Item implements Serializable{

    public float x_max, y_max, x_min, y_min;
    protected String color;

    public Item () {

    }

    public String getColor() {
        return color;
    }
}
