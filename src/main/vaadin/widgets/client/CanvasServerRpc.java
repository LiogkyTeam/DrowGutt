package main.vaadin.widgets.client;

import com.vaadin.shared.communication.ServerRpc;
import item.Item;

//ServerRpc defines the server API for the client part,
// its methods can be called from the client using the remote procedure call mechanism built into Vaadin
public interface CanvasServerRpc extends ServerRpc {
    //public void chooseItem(final Item item);
    void addItem(final Item item);
    void chooseItem(Item item, String sessionID);
    void dismissItem(Item item, String sessionID);
    //public void deleteItem(Item item);
    //public void changeItem(Item olditem, Item newitem);
    void clearCanvas(); /* deletes all objects from canvas */
}