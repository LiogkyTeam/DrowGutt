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
        Canvas canvas = new Canvas(items);
        WorkEnv.put(ui, canvas);
    }

    public void registerUI(long password, com.vaadin.ui.UI ui) throws WrongPassword{
        if (identity != password) throw new WrongPassword();
        if (WorkEnv.containsKey(ui)) return;
        Canvas canvas = new Canvas(items);
        WorkEnv.put(ui, canvas);
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
