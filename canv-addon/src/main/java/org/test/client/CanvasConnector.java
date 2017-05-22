package org.test.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.PostLayoutListener;
import com.vaadin.client.ui.SimpleManagedLayout;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.Connect;
import org.test.client.item.Item;
import org.test.client.item.ItemContainer;

@SuppressWarnings("serial")
@Connect(org.test.Canvas.class)
public class CanvasConnector extends AbstractComponentConnector implements
        SimpleManagedLayout, PostLayoutListener {
    private boolean needsDraw = false;

    private final List<Command> commands;

    private final Map<String, CanvasGradient> gradients = new HashMap<String, CanvasGradient>();

    private final CanvasServerRpc rpc = RpcProxy.create(CanvasServerRpc.class,
            this);

    public CanvasConnector() {
        commands = new ArrayList<Command>();
    }

    @Override
    protected void init() {
        super.init();

        getWidget().addMouseDownHandler(new MouseDownHandler() {
            @Override
            public void onMouseDown(MouseDownEvent event) {
                MouseEventDetails med = MouseEventDetailsBuilder
                        .buildMouseEventDetails(event.getNativeEvent(),
                                getWidget().getElement());
                rpc.mouseDown(med);
            }
        });

        getWidget().addMouseUpHandler(new MouseUpHandler() {
            @Override
            public void onMouseUp(MouseUpEvent event) {
                MouseEventDetails med = MouseEventDetailsBuilder
                        .buildMouseEventDetails(event.getNativeEvent(),
                                getWidget().getElement());
                rpc.mouseUp(med);
            }
        });

        registerRpc(CanvasClientRpc.class, new CanvasClientRpc() {
            private static final long serialVersionUID = -7521521510799765779L;

            private final Context2d ctx = getWidget().getContext2d();

            @Override
            public void setGradientFillStyle(final String gradientName) {
                if (gradients.containsKey(gradientName)){
                    runCommand(() -> {
                        getWidget().setGradientFillStyle(gradients.get(gradientName));
                    });
                }
                else System.err
                        .println("setGradientFillStyle: Gradient not found with name "
                                + gradientName);
            }

            @Override
            public void createLinearGradient(final String name,
                                             final Double x0, final Double y0, final Double x1,
                                             final Double y1) {
                runCommand(() -> {gradients.put(name, getWidget().createLinearGradient(x0, y0, x1, y1));});
            }

            @Override
            public void createRadialGradient(final String name,
                                             final Double x0, final Double y0, final Double r0,
                                             final Double x1, final Double y1, final Double r1) {
                runCommand(() -> {gradients.put(name, getWidget().createRadialGradient(x0, y0, r0, x1, y1, r1));});
            }

            @Override
            public void setGradientStrokeStyle(final String gradientName) {
                if (gradients.containsKey(gradientName)){
                    runCommand(() -> {getWidget().setGradientStrokeStyle(gradients.get(gradientName));});
                }
                else System.err
                        .println("setGradientFillStyle: Gradient not found with name "
                                + gradientName);
            }

            @Override
            public void addColorStop(final String gradientName,
                                     final Double offset, final String color) {
                if (gradients.containsKey(gradientName)) {
                    runCommand(() -> {gradients.get(gradientName).addColorStop(offset, color);});
                } else {
                    System.err
                            .println("addColorStop: Gradient not found with name "
                                    + gradientName);
                }

            }

            @Override
            public void fillRect(final Double startX, final Double startY,
                                 final Double width, final Double height) {
                runCommand(() -> {getWidget().fillRect(startX, startY, width, height);});
            }

            @Override
            public void drawImage1(final String url, final Double offsetX,
                                   final Double offsetY) {
                runCommand(() -> {getWidget().drawImage1(url, offsetX, offsetY);});
            }

            @Override
            public void drawImage2(final String url, final Double offsetX,
                                   final Double offsetY, final Double imageWidth,
                                   final Double imageHeight) {
                runCommand(() -> {getWidget().drawImage2(url, offsetX, offsetY,
                        imageWidth, imageHeight);});
            }

            @Override
            public void drawImage3(final String url, final Double sourceX,
                                   final Double sourceY, final Double sourceWidth,
                                   final Double sourceHeight, final Double destX,
                                   final Double destY, final Double destWidth,
                                   final Double destHeight) {
                runCommand(() -> {getWidget().drawImage3(url, sourceX, sourceY, sourceWidth, sourceHeight,
                        destX, destY, destWidth, destHeight);});
            }

            @Override
            public void fill() {
                runCommand(() -> {getWidget().fill();});
            }

            @Override
            public void fillText(final String text, final Double x,
                                 final Double y, final Double maxWidth) {
                runCommand(() -> {getWidget().fillText(text, x, y, maxWidth);});
            }

            @Override
            public void setFont(final String font) {
                runCommand(() -> {getWidget().setFont(font);});
            }

            @Override
            public void setTextBaseline(final String textBaseline) {
                runCommand(() -> {getWidget().setTextBaseline(textBaseline);});
            }

            @Override
            public void lineTo(final Double x, final Double y) {
                runCommand(() -> {getWidget().lineTo(x, y);});
            }

            @Override
            public void moveTo(final Double x, final Double y) {
                runCommand(() -> {getWidget().moveTo(x, y);});
            }

            @Override
            public void quadraticCurveTo(final Double cpx, final Double cpy,
                                         final Double x, final Double y) {
                runCommand(() -> {getWidget().quadraticCurveTo(cpx, cpy, x, y);});
            }

            @Override
            public void bezierCurveTo(final double cp1x, final double cp1y,
                                      final double cp2x, final double cp2y, final double x,
                                      final double y) {
                runCommand(() -> {getWidget().bezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y);});
            }

            @Override
            public void rect(final Double startX, final Double startY,
                             final Double rectWidth, final Double rectHeight) {
                runCommand(() -> {getWidget().rect(startX, startY, rectWidth, rectHeight);});
            }

            @Override
            public void rotate(final Double angle) {
                runCommand(() -> {getWidget().rotate(angle);});
            }

            @Override
            public void setFillStyle(final String color) {
                runCommand(() -> {getWidget().setFillStyle(color);});
            }

            @Override
            public void setLineCap(final String lineCap) {
                runCommand(() -> {getWidget().setLineCap(lineCap);});
            }

            @Override
            public void setLineJoin(final String lineJoin) {
                runCommand(() -> {getWidget().setLineJoin(lineJoin);});
            }

            @Override
            public void setLineWidth(final Double lineWidth) {
                runCommand(() -> {getWidget().setLineWidth(lineWidth);});
            }

            @Override
            public void setMiterLimit(final Double miterLimit) {
                runCommand(() -> {getWidget().setMiterLimit(miterLimit);});
            }

            @Override
            public void strokeRect(final Double startX, final Double startY,
                                   final Double strokeWidth, final Double strokeHeight) {
                runCommand(() -> {getWidget().strokeRect(startX, startY, strokeWidth, strokeHeight);});
            }

            @Override
            public void transform(final Double m11, final Double m12,
                                  final Double m21, final Double m22, final Double dx,
                                  final Double dy) {
                runCommand(() -> {getWidget().transform(m11, m12, m21, m22, dx, dy);});
            }

            @Override
            public void arc(final Double x, final Double y,
                            final Double radius, final Double startAngle,
                            final Double endAngle, Boolean antiClockwise) {
                runCommand(() -> {getWidget().arc(x, y, radius, startAngle, endAngle, antiClockwise);});
            }

            @Override
            public void translate(final Double x, final Double y) {
                runCommand(() -> {getWidget().translate(x, y);});
            }

            @Override
            public void scale(final Double x, final Double y) {
                runCommand(() -> {getWidget().scale(x, y);});
            }

            @Override
            public void stroke() {
                runCommand(() -> {getWidget().stroke();});
            }

            @Override
            public void saveContext() {
                runCommand(() -> {getWidget().saveContext();});
            }

            @Override
            public void restoreContext() {
                runCommand(() -> {getWidget().restoreContext();});
            }

            @Override
            public void setStrokeStyle(final String rgb) {
                runCommand(() -> {getWidget().setStrokeStyle(rgb);});
            }

            @Override
            public void beginPath() {
                runCommand(() -> {getWidget().beginPath();});
            }

            @Override
            public void clear() {
                getWidget().clear();
                clearCommands();
            }

            @Override
            public void setGlobalAlpha(final Double alpha) {
                runCommand(() -> {getWidget().setGlobalAlpha(alpha);});
            }

            @Override
            public void closePath() {
                runCommand(() -> {getWidget().closePath();});
            }

            @Override
            public void setGlobalCompositeOperation(final String mode) {
                runCommand(() -> {getWidget().setGlobalCompositeOperation(mode);});
            }

            @Override
            public void loadImages(final String[] urls) {
                final List<String> imagesToLoad = new ArrayList<String>();
                imagesToLoad.addAll(Arrays.asList(urls));

                for (final String url : urls) {
                    final Image image = new Image(url);

                    image.addLoadHandler(new LoadHandler() {
                        @Override
                        public void onLoad(LoadEvent event) {
                            RootPanel.get().remove(image);
                            imagesToLoad.remove(url);

                            if (imagesToLoad.isEmpty())
                                rpc.imagesLoaded();
                        }
                    });

                    image.addErrorHandler(new ErrorHandler() {
                        @Override
                        public void onError(ErrorEvent event) {
                            RootPanel.get().remove(image);
                            imagesToLoad.remove(url);

                            if (imagesToLoad.isEmpty())
                                rpc.imagesLoaded();
                        }
                    });

                    // Force loading of the image
                    image.setVisible(false);
                    RootPanel.get().add(image);
                }
            }


            @Override
            public void addItem(Item item){
                item.draw(getWidget());
            }

            /*@Override
            public void changeItem(ItemContainer items, Item item){
                getWidget().clear();
                for (Item draw: items.getItems()) draw.draw(getWidget());
            }*/

            /*public void test(){
            }*/
            //TODO: Stepan, fill this method
            @Override
            public void startDrawLines(String color, int thickness){
                ///getWidget().
            }
            @Override
            public void startDrawCurves(String color, int thickness){
                ///getWidget().
            }
            @Override
            public void startDrawPoints(String color, int thickness){
                ///getWidget().
            }
            @Override
            public void startDrawRectangles(String color, int thickness){
                ///getWidget().
            }
            @Override
            public void startDrawCubicBezier(String color, int thickness){
                ///getWidget().
            }
            @Override
            public void startDrawQuadBezier(String color, int thickness){
                ///getWidget().
            }
            @Override
            public void endDraw(){
                //getWidget().
            }
        });
    }

    @Override
    public void layout() {
        int newHt = getWidget().getElement().getOffsetHeight();
        if (newHt != getWidget().getCoordinateSpaceHeight()) {
            getWidget().setCoordinateSpaceHeight(newHt);
            needsDraw = true;
        }

        int newWt = getWidget().getElement().getOffsetWidth();
        if (newWt != getWidget().getCoordinateSpaceWidth()) {
            getWidget().setCoordinateSpaceWidth(newWt);
            needsDraw = true;
        }
    }

    @Override
    public void postLayout() {
        if (needsDraw) {
            for (Command cmd : commands)
                cmd.execute();
            needsDraw = false;
        }
    }

    public void runCommand(Command command) {
        if (commands.add(command))
            command.execute();
    }

    public void clearCommands() {
        commands.clear();
    }

    @Override
    protected Widget createWidget(){
        CanvasWidget widget = new CanvasWidget();
        widget.addRpc(rpc);
        return widget;
    }

    @Override
    public CanvasWidget getWidget() {
        return (CanvasWidget) super.getWidget();
    }

    @Override
    public CanvasState getState() {
        return (CanvasState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        // Only add a mouse move handler if someone is interested in, as
        // otherwise
        // they would generate a large amount of server side traffic.
        if (stateChangeEvent.hasPropertyChanged("listenMouseMove")
                && getState().listenMouseMove)
            getWidget().addMouseMoveHandler(new MouseMoveHandler() {
                @Override
                public void onMouseMove(MouseMoveEvent event) {
                    if (getState().listenMouseMove) {
                        MouseEventDetails med = MouseEventDetailsBuilder
                                .buildMouseEventDetails(event.getNativeEvent(),
                                        getWidget().getElement());

                        rpc.mouseMoved(med);
                    }
                }
            });
    }

}

