/*package alex;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import com.vaadin.client.ui.AbstractComponentConnector;

@Connect(TodoList.class)
public class TodoListConnector extends AbstractComponentConnector{
 
    private final TodoListServerRpc rpc = RpcProxy.create(
            TodoListServerRpc.class, this);
 
    @Override
    protected void init() {
        super.init();
        registerRpc(TodoListClientRpc.class, new TodoListClientRpc() {
            @Override
            public void blinkTask(final int id) {
                getWidget().blinkTask(id);
            }
        });
    }
 
    @Override
    protected Widget createWidget() {
        final TodoListWidget widget = GWT.create(TodoListWidget.class);
        widget.addTodoListWidgetListener(this);
        return widget;
    }
 
    @Override
    public TodoListState getState() {
        return (TodoListState) super.getState();
    }
 
    @Override
    public TodoListWidget getWidget() {
        return (TodoListWidget) super.getWidget();
    }
 
    @Override
    public void onStateChanged(final StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
 
        getWidget().clearTodoList();
        for (final TodoListState.Task task : getState().tasks) {
            getWidget().addTask(task.id, task.caption, task.done);
        }
 
        getWidget().setReadOnly(getState().readOnly);
    }
 
    @Override
    public void taskRemoved(final int id) {
        rpc.removeTask(id);
    }
 
    @Override
    public void captionChanged(final int id, final String value) {
        rpc.setTaskCaption(id, value);
    }
 
    @Override
    public void doneChanged(final int id, final boolean value) {
        rpc.setTaskDone(id, value);
    }
}*/