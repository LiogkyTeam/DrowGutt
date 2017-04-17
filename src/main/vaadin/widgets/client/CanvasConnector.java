package main.vaadin.widgets.client;

import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import main.vaadin.widgets.Canvas;
import main.vaadin.widgets.shared.CanvasState;

/**
 * Created by Alexey on 17.04.2017.
 */
// Connector binds client-side widget class to server-side component class
// Connector lives in the client and the @Connect annotation specifies the
// corresponding server-side component
@Connect(Canvas.class)
public class CanvasConnector  extends AbstractComponentConnector {
    //private final CanvasServerRpc rpc = RpcProxy.create(CanvasServerRpc.class, this);

    // We must implement createWidget() to create correct type of widget
   /* protected Widget createWidget() {
        CanvasWidget widget = new CanvasWidget(getState().canvasWidth, getState().canvasHeight);
        return widget;
    }

    // We must implement getState() to cast to correct type
    @Override
    public CanvasState getState() {
        return (CanvasState) super.getState();
    }

    // We must implement getWidget() to cast to correct type
    @Override
    public CanvasWidget getWidget() {
        return (CanvasWidget) super.getWidget();
    }
    // Whenever the state changes in the server-side, this method is called
    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (getState().canvasWidth != getWidget().canv.getCoordinateSpaceWidth() || getState().canvasHeight != getWidget().canv.getCoordinateSpaceHeight()) {
            getWidget().updateCanvasSize(getState().canvasWidth, getState().canvasHeight);
        }
        if (getState().lines.size() > getWidget().lines) {
            updateLines();
        }
        //need to write if-s to correct change state of Canvas
    }*/
}
