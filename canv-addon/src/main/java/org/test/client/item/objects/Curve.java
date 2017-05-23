package org.test.client.item.objects;

import com.google.gwt.canvas.dom.client.Context2d;
import org.test.client.CanvasWidget;
import org.test.client.item.Item;

import java.util.ArrayList;

/**
 * Created by Alexey on 16.05.2017.
 */
public class Curve extends Item {
    private ArrayList<Point> curve;

    public Curve() {
    }

    public Curve(ArrayList<Point> curve) {
        this.curve = curve;
        setBorders(curve.get(0).getX(), curve.get(0).getX(), 0, 0);
       setBorders(curve);
    }

    private void setBorders(ArrayList<Point> points){
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
        curve.get(0).draw(canvas);
        canvas.moveTo((double) curve.get(0).getX(), (double) curve.get(0).getY());
        Context2d ctx = canvas.getContext2d();
        ctx.beginPath();
        ctx.setLineWidth(5);
        ctx.setStrokeStyle(canvas.color);
        for (int i = 1; i < curve.size(); i++) {
            curve.get(i).draw(canvas);
            canvas.moveTo((double) curve.get(i).getX(), (double) curve.get(i).getY());
            canvas.lineTo((double) curve.get(i).getX(), (double) curve.get(i).getY());
        }
    }
}
