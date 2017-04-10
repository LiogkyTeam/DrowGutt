package alex;

import com.vaadin.shared.communication.ClientRpc;

public interface TodoListClientRpc extends ClientRpc {
    void blinkTask(int id);
}