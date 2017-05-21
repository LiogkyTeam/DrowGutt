package org.test.ui;


import org.test.Canvas;
import org.test.client.item.ItemContainer;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private long identity;
    Map<com.vaadin.ui.UI, Canvas> WorkEnv = new HashMap<com.vaadin.ui.UI, Canvas>();
    private ItemContainer items = new ItemContainer();

    public Room(long password, com.vaadin.ui.UI ui){
        identity = password;
        registerUI(password, ui);
    }

    public String registerUI(long password, com.vaadin.ui.UI ui){
        if (identity != password) return "Wrong password, try join to room again";
        if (WorkEnv.containsKey(ui)) return "You have already registered";
        Canvas canvas = new Canvas(items);
        WorkEnv.put(ui, canvas);
        return "You successfully joined to room";
    }

    public Canvas getCanvas(com.vaadin.ui.UI ui){
        if (WorkEnv.containsKey(ui)) return WorkEnv.get(ui);
        else return null;
    }

    @Deprecated
    public Room(){
        identity = 0;
    }

}
