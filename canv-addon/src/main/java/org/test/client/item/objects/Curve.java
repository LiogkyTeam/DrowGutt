package org.test.client.item.objects;

import org.test.client.CanvasWidget;
import org.test.client.item.Item;

/**
 * Created by Alexey on 16.05.2017.
 */
public class Curve extends Item {
    private Point[] curve;

    public Curve() {
    }

    public Curve(Point[] curve) {
        this.curve = curve;
        setBorders(curve[0].getX(), curve[0].getX(), 0, 0);
       setBorders(curve);
    }

    private void setBorders(Point[] points){
        int x_min = getX_min(), x_max = getX_max(),
                y_min = getY_min(), y_max = getY_max();
        for (Point point: points) {
            if (x_min > point.getX())
                x_min = point.getX();
            else if (x_max < point.getX())
                x_max = point.getX();
            if (y_min > point.getY())
                y_min = point.getY();
            else if (y_max < point.getY())
                y_max = point.getY();
        }
        setBorders(x_min, y_min, x_max, y_max);
    }

    public void draw(CanvasWidget canvas)
    {
        curve[0].draw(canvas);
        for (int i = 1; i < curve.length; i++) {
            canvas.moveTo((double) curve[i - 1].getX(), (double) curve[i - 1].getY());
            curve[i].draw(canvas);
            canvas.lineTo((double) curve[i].getX(), (double) curve[i].getY());
        }
    }
}
