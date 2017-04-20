package main.vaadin.widgets;


import com.vaadin.ui.UI;
import item.Item;
import item.ItemContainer;
import main.vaadin.widgets.client.CanvasServerRpc;
import main.vaadin.widgets.shared.CanvasState;

// This is the server-side UI component that provides public API for Canvas:
// various get/set methods for work, event listeners and data source connections

//realization is rather simple because the most events are processed on client
public class Canvas extends com.vaadin.ui.AbstractComponent {
    //the following field need for serialization, better to change it to more hard after some time
    //private static final long serialVersionUID = 1L;

    private CanvasServerRpc rpc = new CanvasServerRpc() {
        @Override
        public void addItem(Item item) {
            getState().itemContainer.addItem(item);
        }
        @Override
        public void chooseItem(Item item, String sessionID){
            item.setBlock(sessionID);
        }
        @Override
        public void dismissItem(Item item, String sessionID){
            item.rmBlock(sessionID);
        }
   };


    // We must override getState() to cast the state to CanvasState
    @Override
    public CanvasState getState() {
        return (CanvasState) super.getState();
    }

    public Canvas(ItemContainer items, float width, float height){
        registerRpc(rpc);
        if (items != null) getState().itemContainer = items;
        getState().canvasWidth = width;
        getState().canvasHeight = height;
        //ui = UI.getCurrent();
        //sessionID = ui.getSession().getSession().getId();
    }

    public Canvas(float width, float height){
        registerRpc(rpc);
        getState().canvasWidth = width;
        getState().canvasHeight = height;
        //ui = UI.getCurrent();
        //sessionID = ui.getSession().getSession().getId();
    }

    public Canvas(){
        registerRpc(rpc);
        final int defaultWidth = 600;
        final int defaultHeight = 800;
        getState().canvasWidth = defaultWidth;
        getState().canvasHeight = defaultHeight;
        //ui = UI.getCurrent();
        //sessionID = ui.getSession().getSession().getId();
    }

    public void clear(){
        getState().itemContainer.clear();
    }

}