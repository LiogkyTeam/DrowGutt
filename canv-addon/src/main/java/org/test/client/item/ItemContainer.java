package org.test.client.item;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemContainer implements Serializable {
    private ArrayList<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    //Returns the Item that currently reflects the specified Item in the ItemContainer
    public Item getCurItem(Item item) {
        long id = item.getID();
        for (Item curItem : items) {
            if (id == curItem.getID()) return curItem;
        }
        return null;
    }

    //If return true then Item successfuly changed
    public boolean changeExistsItem(Item item) {
        long id = item.getID();
        int i = 0;
        for (Item curItem : items) {
            if (id == curItem.getID()) {
                if (!curItem.equals(item)) items.set(i, item);
                return true;
            }
            i++;
        }
        return false;
    }

    //If item contains in ItemContain then it will replaced to income item, else add(item)
    public void changeItem(Item item) {
        if (changeExistsItem(item)) return;
        items.add(item);
    }

    public void clear() {
        items.clear();
    }
}