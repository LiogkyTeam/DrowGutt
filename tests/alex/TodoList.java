package alex;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractComponent;

@StyleSheet("todolist.css")
public class TodoList extends AbstractComponent implements TodoListServerRpc {
 
    //private static final String STYLE_NAME = "todolist";
 
    public TodoList() {
        registerRpc(this, TodoListServerRpc.class);
        //setStyleName(STYLE_NAME);
    }
 
    public final int addTask() {
        final Integer id = getMaxId() + 1;
        if (getTask(id) == null) {
            final Task task = new Task();
            task.setId(id);
            getState().tasks.add(task);
            setTaskCaption(id, "Task " + id);
        }
        return id;
    }
 
    @Override
    public final void removeTask(final int id) {
        getState().tasks.remove(getTask(id));
    }
 
    @Override
    public final void setTaskCaption(final int id, final String caption) {
        final Task task = getTask(id);
        if (task != null) {
            task.setCaption(caption);
        }
    }
 
    @Override
    public final void setTaskDone(final int id, final boolean value) {
        final Task task = getTask(id);
        if (task != null) {
            task.setDone(value);
        }
    }
 
 /*   @Override
    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
    }*/
 
    public final void blinkTask(final int id) {
        getRpcProxy(TodoListClientRpc.class).blinkTask(id);
    }
 
    private Task getTask(final Integer id) {
        Task result = null;
        for (final Task task : getState().tasks) {
            if (id == task.getId()) {
                result = task;
            }
        }

        return result;
    }
 
    @Override
    protected final TodoListState getState() {
        return (TodoListState) super.getState();
    }
 
    public final int getMaxId() {
        int id = 0;
        for (final Task task : getState().tasks) {
            id = Math.max(id, task.getId());
        }
        return id;
    }
}