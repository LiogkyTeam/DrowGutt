package org.test.client.item;

import org.test.client.CanvasWidget;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable, Blockable{

    private static long identity = 0;

    private long id;
    private Date last_modified = new Date();

    private boolean block = false;
    private String blocksession;

    private int x_max;
    private int y_max;
    private int x_min;
    private int y_min;
    protected String color;

    public Item () {
        change();
        id = identity++;
    }

    public Item(int x_max, int y_max, int x_min, int y_min) {
        change();
        this.x_max = x_max;
        this.y_max = y_max;
        this.x_min = x_min;
        this.y_min = y_min;
        id = identity++;
    }

    private void change(){
        last_modified.getTime();
    }

    //return true if SetBlock is successful
    public boolean setBlock(String sessionID){
        if (!hasBlock()) {
            block = true;
            blocksession = sessionID;
            change();
            return true;
        }
        return false;
    }

    public boolean hasBlock(){
        return block;
    }

    //return sessionID of the client's session that blocked the object
    public String whoBlock(){
        if (hasBlock()) return blocksession;
        else return null;
    }

    //returns true if block removed
    public boolean rmBlock(String sessionID){
        if (blocksession.equals(sessionID))
        {
            if (block == true) change();
            block = false;
        }
        return !block;
    }

    //delete block in anyway
    //to use only in particular cases!!!
    public void sudormBlock(){
        if (block == true) change();
        block = false;
    }

    public boolean getBlock(){
        return block;
    }

    public void setX_max(int x_max) {
        if (this.x_max != x_max) change();
        this.x_max = x_max;
    }

    public void setY_max(int y_max) {
        if (this.y_max != y_max) change();
        this.y_max = y_max;
    }

    public void setX_min(int x_min) {
        if (this.x_min != x_min) change();
        this.x_min = x_min;
    }

    public void setY_min(int y_min) {
        if (this.y_min != y_min) change();
        this.y_min = y_min;
    }

    public int getX_max() {
        return x_max;
    }

    public int getY_max() {
        return y_max;
    }

    public int getX_min() {
        return x_min;
    }

    public int getY_min() {
        return y_min;
    }

    public void setBorders(int x_min, int y_min, int x_max, int y_max){
        setX_min(x_min);
        setY_min(y_min);
        setX_max(x_max);
        setY_max(y_max);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (!this.color.equals(color)) change();
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        return last_modified != null ? last_modified.equals(item.last_modified) : item.last_modified == null;
    }

    long getID(){
        return id;
    }

    //this method necessary to override!!!
    public void draw(CanvasWidget canvas){
        //Write here some default realization
    }
}