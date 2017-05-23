package org.test.client.item.objects;

import org.test.client.CanvasWidget;
import org.test.client.item.Item;
import java.io.Serializable;

/**
 * Created by Alexey on 16.05.2017.
 */
public class Point extends Item implements Serializable {
    private int x;
    private int y;

    public Point ()
    {

    }

    public Point(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(CanvasWidget canvas)
    {
        canvas.fillRect((double) x, (double) y, 2.0, 2.0);
    }
}
