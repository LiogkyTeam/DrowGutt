package alex;

import com.vaadin.shared.AbstractComponentState;

public class Task extends AbstractComponentState{
        private int id;
        private String caption;
        private boolean done;

    public void setId(int id) {
        this.id = id;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }
}