package org.test;


import com.vaadin.ui.UI;
import org.test.client.item.Item;

public abstract class CanvasUpdateListener {
    private final UI ui;

    public CanvasUpdateListener(UI ui) {
        this.ui = ui;
    }

    public UI getUi() {
        return ui;
    }

    public abstract void addedItem(Item item);

    public abstract void changedItem(Item item);

    public abstract void deletedItem(Item item);
}
