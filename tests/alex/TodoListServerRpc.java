package alex;

import com.vaadin.shared.communication.ServerRpc;

public interface TodoListServerRpc extends ServerRpc {
    void removeTask(int id);
 
    void setTaskCaption(int id, String value);
 
    void setTaskDone(int id, boolean value);
}