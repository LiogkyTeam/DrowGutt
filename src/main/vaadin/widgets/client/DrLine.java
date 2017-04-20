package main.vaadin.widgets.client;

/**
 * Created by Степан on 18.04.2017.
 */
import item.Item;

import java.util.ArrayList;
import java.util.List;

public class DrLine extends Item {
    private static final long serialVersionUID = 1L;

    private List<DrPoint> points = new ArrayList<DrPoint>();

    public DrLine() {
    }

    public void addPoint(DrPoint point) {
        points.add(point);
    }

    public List<DrPoint> getPointsFrom(int index) {
        return points.subList(index, points.size() - 1);
    }

    public List<DrPoint> getPoints() {
        return points;
}

    public void addPoints(List<DrPoint> points) {
        this.points.addAll(points);
    }
}
