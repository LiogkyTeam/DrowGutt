package org.test.client.item.objects;

import org.test.client.CanvasWidget;
import org.test.client.item.Item;

/**
 * Created by Alexey on 16.05.2017.
 */
public class Rectangle extends Item{
    public Rectangle ()
    {

    }

    public Rectangle(int x_max, int y_max, int x_min, int y_min) {
        super(x_max, y_max, x_min, y_min);
    }

    public void draw (CanvasWidget canvas)
    {
        canvas.moveTo((double) getX_min(), (double) getY_min());
        canvas.lineTo((double) getX_min(), (double) getY_max());
        canvas.lineTo((double) getX_max(), (double) getY_max());
        canvas.lineTo((double) getX_max(), (double) getY_min());
    }
}
