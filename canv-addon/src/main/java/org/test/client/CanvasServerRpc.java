package org.test.client;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;
import org.test.client.item.Item;

public interface CanvasServerRpc extends ServerRpc {
    void imagesLoaded();

    void addItem(Item item);
}
