package main.vaadin.widgets.shared;

import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import item.Item;
import item.ItemContainer;
import main.vaadin.widgets.Canvas;
import main.vaadin.widgets.client.CanvasWidget;

import static java.awt.SystemColor.text;

@Connect(Canvas.class)
public class CanvasConnector extends AbstractComponentConnector {
	@Override
	public CanvasWidget getWidget() {
		return (CanvasWidget) super.getWidget();
	}
	
	@Override
	public CanvasState getState() {
		return (CanvasState) super.getState();
	}
	
	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent)
	{
		super.onStateChanged(stateChangeEvent);
		
		if (stateChangeEvent.hasPropertyChanged("canvasWidth")) {
			getWidget().setCanvasWidth(getState().canvasWidth);
		}
		if (stateChangeEvent.hasPropertyChanged("canvasHeight")) {
			getWidget().setCanvasHeight(getState().canvasHeight);
		}
		
		final ItemContainer itemContainer = getState().itemContainer;
		if (stateChangeEvent.hasPropertyChanged("itemContainer")) {
			getWidget().itemContainer = itemContainer;
			/* for(Item i : itemContainer) {
				itemContainer.changeItem(i);
			} */
		}
	}
}
