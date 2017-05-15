package org.test.client.item.objects;

import org.test.client.item.Item;

/**
 * Created by Alexey on 16.05.2017.
 */
public class Line extends Item{
    private int start_x;
    private int start_y;
    private int end_x;
    private int end_y;

    public Line(int start_x, int start_y, int end_x, int end_y, String color) {
        super();
        int x_max = start_x, x_min = end_x, y_max = start_y, y_min = end_y;
        if(start_x < end_x) {
            x_max = end_x;
            x_min = start_x;
        }

        if(start_y < end_y) {
            y_max = end_y;
            y_min = start_y;
        }
        setBorders(x_min, y_min, x_max, y_max);
        setColor(color);
        this.start_x = start_x;
        this.start_y = start_y;
        this.end_x = end_x;
        this.end_y = end_y;
    }
}
