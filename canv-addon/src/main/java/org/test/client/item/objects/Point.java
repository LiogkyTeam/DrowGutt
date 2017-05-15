package org.test.client.item.objects;

/**
 * Created by Alexey on 16.05.2017.
 */
public class Point {
    private int x;
    private int y;
    private String color;

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

    public String getColor() {
        return color;
    }
}
