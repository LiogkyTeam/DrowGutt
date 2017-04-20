package main.vaadin.widgets.client;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.Touch;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import item.Item;
import main.vaadin.widgets.shared.CanvasConnector;

/**
 * Created by Alexey on 17.04.2017.
 */
public class CanvasWidget extends VerticalPanel {

    final com.google.gwt.canvas.client.Canvas canv;
    private float last_x = 0;
    private float last_y = 0;
    private boolean mode = true;
    boolean drawing = false;
    private String penColor;
    private Item currentObj;
    private float dist_buffer = 10;
    CanvasConnector connector = new CanvasConnector();
    private CanvasServerRpc rpc;


    public CanvasWidget(float canvasWidth, float canvasHeight, String color) {

        canv = com.google.gwt.canvas.client.Canvas.createIfSupported();
        canv.setSize(canvasWidth + "px", canvasHeight + "px");

        penColor = color;

        add(canv);

        canv.addMouseDownHandler(new MouseDownHandler() {

            @Override
            public void onMouseDown(MouseDownEvent event) {
                if (mode)
                    startDrawingLine(event.getClientX(), event.getClientY());
                //else
                //startDrawingRect(event.getClientX(), event.getClientY());
            }
        });

        canv.addMouseMoveHandler(new MouseMoveHandler() {

            @Override
            public void onMouseMove(MouseMoveEvent event) {
                if (drawing) {
                    if (mode)
                        continueDrawingLine(event.getClientX(), event.getClientY());
                    //else
                    //continueDrawingRect(event.getClientX(), event.getClientY());
                }
            }
        });

        canv.addTouchStartHandler(new TouchStartHandler() {

            @Override
            public void onTouchStart(TouchStartEvent event) {
                if (event.getTouches().length() == 1) {
                    Touch firstTouch = event.getTouches().get(0);
                    if (mode)
                        startDrawingLine(firstTouch.getClientX(), firstTouch.getClientY());
                    //else
                    //startDrawingRect(firstTouch.getClientX(), firstTouch.getClientY());
                }
            }
        });

        canv.addTouchMoveHandler(new TouchMoveHandler() {

            @Override
            public void onTouchMove(TouchMoveEvent event) {
                if (drawing && event.getTouches().length() == 1) {
                    Touch firstTouch = event.getTouches().get(0);
                    if (mode)
                        continueDrawingLine(firstTouch.getClientX(), firstTouch.getClientY());
                    //else
                    // continueDrawingRect(firstTouch.getClientX(), firstTouch.getClientY());
                    event.preventDefault();
                }
            }
        });
    }

    protected void startDrawingLine(int clientX, int clientY) {
        drawing = true;
        DrLine newLine = new DrLine();
        rpc.addItem(newLine);
        float x = clientX - canv.getAbsoluteLeft() + Window.getScrollLeft();
        float y = clientY - canv.getAbsoluteTop() + Window.getScrollTop();
        newLine.addPoint(new DrPoint(x, y));
        last_x = x;
        last_y = y;
    }

    private void continueDrawingLine(int clientX, int clientY) {
        Context2d context = canv.getContext2d();
        float x = clientX - canv.getAbsoluteLeft() + Window.getScrollLeft();
        float y = clientY - canv.getAbsoluteTop() + Window.getScrollTop();

        if (getDistance(last_x, last_y, x, y) > dist_buffer) {
            context.beginPath();
            context.setLineWidth(5);
            context.setStrokeStyle(penColor);
            context.moveTo(last_x, last_y);
            context.lineTo(x, y);
            context.moveTo(x, y);
            context.closePath();
            context.stroke();
            if(mode & currentObj.getClass().equals(DrLine.class))
                ((DrLine)currentObj).addPoint(new DrPoint(x, y));
            last_x = x;
            last_y = y;
        }
    }

    protected void endDrawingLine() {
        drawing = false;
        //rpc.drawingEnded(line);
        last_x = 0;
        last_y = 0;
    }

    public void drawLine(DrLine line) {
        Context2d context = canv.getContext2d();
        context.beginPath();
        context.setLineWidth(5);
        context.setStrokeStyle(line.getColor());
        boolean first = true;
        for(DrPoint point : line.getPoints()) {
            if (first) {
                context.moveTo(point.x, point.y);
                first = false;
            } else {
                context.lineTo(point.x, point.y);
                context.moveTo(point.x, point.y);
            }
        }
        context.closePath();
        context.stroke();
    }

    protected float getDistance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    public void addRpc(CanvasServerRpc rpc) {
        this.rpc = rpc;
    }
}