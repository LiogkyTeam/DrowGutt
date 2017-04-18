package tests.egor;

import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import main.vaadin.widgets.Canvas;
import main.vaadin.widgets.shared.CanvasState;

@Connect(Canvas.class)
public class CanvasConnector extends AbstractComponentConnector {
    /* private final CanvasServerRpc rpc = RpcProxy.create(CanvasServerRpc.class, this);

    protected CanvasWidget createCanvasWidget() {
        CanvasWidget widget = new CanvasWidget(getState().canvasWidth, getState().canvasHeight);
        return widget;
    }

    @Override
    public CanvasState getState() {
        return (CanvasState) super.getState();
    }

    @Override
    public CanvasWidget getWidget() {
        return (CanvasWidget) super.getWidget();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
    } */
}
