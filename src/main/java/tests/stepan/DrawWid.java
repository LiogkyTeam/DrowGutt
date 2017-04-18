package tests.stepan;

/*
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.Touch;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.ArrayList;
import java.util.Date;

// Extend any GWT Widget
public class DrawWid extends VerticalPanel {

    boolean drawing = false;
    float last_x = 0;
    float last_y = 0;

    private CollabSketchServerRpc rpc;

    static final float dist_buffer = 7;
    static final int updateTime = 50;
    final Canvas canv;
    String color;
    int lines;
    long lastUpdate;
    Button saveImage;

    public @UiConstructor DrawWid(int width, int height, String color) {
        this.color = color;
        setBorderWidth(10);
        setSize(width + "px", height + "px");

        canv = Canvas.createIfSupported();
        canv.setCoordinateSpaceWidth(width);
        canv.setCoordinateSpaceHeight(height);
        canv.setSize(width + "px", height + "px");
        add(canv);

        canv.addMouseDownHandler(new MouseDownHandler() {

            @Override
            public void onMouseDown(MouseDownEvent event) {
                startDrawing(event.getClientX(), event.getClientY());
            }
        });

        canv.addMouseMoveHandler(new MouseMoveHandler() {

            @Override
            public void onMouseMove(MouseMoveEvent event) {
                if (drawing) {
                    continueDrawing(event.getClientX(), event.getClientY());
                }
            }
        });

        canv.addMouseOutHandler(new MouseOutHandler() {

            @Override
            public void onMouseOut(MouseOutEvent event) {
                if (drawing) {
                    endDrawing();
                }
            }
        });

        canv.addMouseUpHandler(new MouseUpHandler() {

            @Override
            public void onMouseUp(MouseUpEvent event) {
                if (drawing) {
                    endDrawing();
                }
            }
        });

        canv.addTouchStartHandler(new TouchStartHandler() {

            @Override
            public void onTouchStart(TouchStartEvent event) {
                if (event.getTouches().length() == 1) {
                    Touch firstTouch = event.getTouches().get(0);
                    startDrawing(firstTouch.getClientX(), firstTouch.getClientY());
                }
            }
        });

        canv.addTouchMoveHandler(new TouchMoveHandler() {

            @Override
            public void onTouchMove(TouchMoveEvent event) {
                if (drawing && event.getTouches().length() == 1) {
                    Touch firstTouch = event.getTouches().get(0);
                    continueDrawing(firstTouch.getClientX(), firstTouch.getClientY());
                    event.preventDefault();
                }
            }
        });

        canv.addTouchEndHandler(new TouchEndHandler() {

            @Override
            public void onTouchEnd(TouchEndEvent event) {
                if (drawing) {
                    endDrawing();
                    event.preventDefault();
                }
            }
        });

        saveImage = new Button("Save as Image");
        saveImage.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Window.open(canv.toDataUrl("image/png"), "Image", "");
            }
        });
        add(saveImage);
    }

    protected void startDrawing(int clientX, int clientY) {
        drawing = true;
        float x = clientX - canv.getAbsoluteLeft() + Window.getScrollLeft();
        float y = clientY - canv.getAbsoluteTop() + Window.getScrollTop();
        points.add(new DrawPoint(x, y));
        last_x = x;
        last_y = y;
    }

    private void continueDrawing(int clientX, int clientY) {
        Context2d context = canv.getContext2d();
        float x = clientX - canv.getAbsoluteLeft() + Window.getScrollLeft();
        float y = clientY - canv.getAbsoluteTop() + Window.getScrollTop();

        if (getDistance(last_x, last_y, x, y) > dist_buffer) {
            context.beginPath();
            context.setLineWidth(5);
            context.setStrokeStyle(color);
            context.moveTo(last_x, last_y);
            context.lineTo(x, y);
            context.moveTo(x, y);
            context.closePath();
            context.stroke();
            points.add(new DrawPoint(x, y));
            last_x = x;
            last_y = y;
            if (lastUpdate + updateTime < new Date().getTime()) {
                endDrawing();
                startDrawing(clientX, clientY);
            }
        }
    }

    protected void endDrawing() {
        drawing = false;
        DrawLine line = new DrawLine();
        line.addPoints(points);
        line.color = color;
        rpc.drawingEnded(line);
        points.clear();
        last_x = 0;
        last_y = 0;
        lastUpdate = new Date().getTime();
        lines++;
    }

    protected float getDistance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    public void addRpc(CollabSketchServerRpc rpc) {
        this.rpc = rpc;
    }

    public void drawLine(DrawLine line) {
        Context2d context = canv.getContext2d();
        context.beginPath();
        context.setLineWidth(5);
        context.setStrokeStyle(line.color);
        boolean first = true;
        for(DrawPoint point : line.points) {
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
        lines++;
    }

    public void clearCanvas() {
        canv.getContext2d().clearRect(0, 0, canv.getCoordinateSpaceWidth(), canv.getCoordinateSpaceHeight());
    }

    public void updateCanvasSize(int canvasWidth, int canvasHeight) {
        canv.setCoordinateSpaceWidth(canvasWidth);
        canv.setCoordinateSpaceHeight(canvasHeight);
        canv.setSize(canvasWidth + "px", canvasHeight + "px");
    }

    public void updateColor(String color) {
        this.color = color;
    }

} */