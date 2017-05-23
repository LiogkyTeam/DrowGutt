package org.test.client;

import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.Window;
import org.test.client.item.objects.Line;
import org.test.client.item.objects.Point;

// Extend any GWT Widget
public class CanvasWidget extends VerticalPanel {
    final com.google.gwt.canvas.client.Canvas canv;
    private Context2d ctx;
    private CanvasServerRpc rpc;
    static final float dist_buffer = 10;
    static final int updateTime = 50;
    long lastUpdateTime;
    int x, y;
    public String color;
    ArrayList<Point> points = new ArrayList<Point>();

    public CanvasWidget(){
        canv = com.google.gwt.canvas.client.Canvas.createIfSupported();
        add(canv);
        ctx = canv.getContext2d();
        color = "ff0000";

        addMouseDownHandler(new MouseDownHandler() {
            @Override
            public void onMouseDown(MouseDownEvent mouseDownEvent) {
                startDrawingCurve(mouseDownEvent.getClientX(), mouseDownEvent.getClientY());
            }
        });

        setStyleName("widget");
    }

    public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler){
        return canv.addMouseMoveHandler(handler);
    }

    public HandlerRegistration addMouseUpHandler(MouseUpHandler handler){
        return canv.addMouseUpHandler(handler);
    }

    public HandlerRegistration addMouseDownHandler(MouseDownHandler handler){
        return canv.addMouseDownHandler(handler);
    }

    public int getCoordinateSpaceWidth(){
        return canv.getCoordinateSpaceWidth();
    }

    public int getCoordinateSpaceHeight(){
        return canv.getCoordinateSpaceHeight();
    }

    public void setCoordinateSpaceWidth(int width){
        canv.setCoordinateSpaceWidth(width);
    }

    public void setCoordinateSpaceHeight(int height){
        canv.setCoordinateSpaceWidth(height);
    }

    public void setSizes(int width, int height) {
        canv.setCoordinateSpaceWidth(height);
        canv.setCoordinateSpaceWidth(width);
        canv.setSize(width + "px", height + "px");
    }

    public Context2d getContext2d(){
        return canv.getContext2d();
    }

    public void fillRect(final Double startX, final Double startY,
                         final Double width, final Double height) {
        ctx.fillRect(startX, startY, width, height);
    }

    public void drawImage1(final String url, final Double offsetX,
                           final Double offsetY) {
        ctx.drawImage(ImageElement.as(new Image(url).getElement()),
                        offsetX, offsetY);
    }

    public void drawImage2(final String url, final Double offsetX,
                           final Double offsetY, final Double imageWidth,
                           final Double imageHeight) {
        ctx.drawImage(ImageElement.as(new Image(url).getElement()),
                        offsetX, offsetY, imageWidth, imageHeight);

    }

    public void drawImage3(final String url, final Double sourceX,
                           final Double sourceY, final Double sourceWidth,
                           final Double sourceHeight, final Double destX,
                           final Double destY, final Double destWidth,
                           final Double destHeight) {
        ctx.drawImage(ImageElement.as(new Image(url).getElement()),
                        sourceX, sourceY, sourceWidth, sourceHeight,
                        destX, destY, destWidth, destHeight);
    }

    public void fill() {
        ctx.fill();
    }

    public void fillText(final String text, final Double x,
                         final Double y, final Double maxWidth) {
        ctx.fillText(text, x, y, maxWidth);
    }

    public void setFont(final String font) {
        ctx.setFont(font);
    }

    public void setTextBaseline(final String textBaseline) {
        ctx.setTextBaseline(textBaseline);
    }

    public void lineTo(final Double x, final Double y) {
        ctx.lineTo(x, y);
    }

    public void moveTo(final Double x, final Double y) {
        ctx.moveTo(x, y);
    }

    public void quadraticCurveTo(final Double cpx, final Double cpy,
                                 final Double x, final Double y) {
        ctx.quadraticCurveTo(cpx, cpy, x, y);
    }

    public void bezierCurveTo(final double cp1x, final double cp1y,
                              final double cp2x, final double cp2y, final double x,
                              final double y) {
        ctx.bezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y);
    }

    public void rect(final Double startX, final Double startY,
                     final Double rectWidth, final Double rectHeight) {
        ctx.rect(startX, startY, rectWidth, rectHeight);
    }

    public void rotate(final Double angle) {
        ctx.rotate(angle);
    }

    public void setFillStyle(final String color) {
        ctx.setFillStyle(color);
    }

    public void setLineCap(final String lineCap) {
        ctx.setLineCap(lineCap);
    }

    public void setLineJoin(final String lineJoin) {
        ctx.setLineJoin(lineJoin);
    }

    public void setLineWidth(final Double lineWidth) {
        ctx.setLineWidth(lineWidth);
    }

    public void setMiterLimit(final Double miterLimit) {
        ctx.setMiterLimit(miterLimit);
    }

    public void strokeRect(final Double startX, final Double startY,
                           final Double strokeWidth, final Double strokeHeight) {
        ctx.strokeRect(startX, startY, strokeWidth,
                        strokeHeight);
    }

    public void transform(final Double m11, final Double m12,
                          final Double m21, final Double m22, final Double dx,
                          final Double dy) {
        ctx.transform(m11, m12, m21, m22, dx, dy);
    }

    public void arc(final Double x, final Double y,
                    final Double radius, final Double startAngle,
                    final Double endAngle, Boolean antiClockwise) {
        ctx.arc(x, y, radius, startAngle, endAngle);
    }

    public void translate(final Double x, final Double y) {
        ctx.translate(x, y);
    }

    public void scale(final Double x, final Double y) {
        ctx.scale(x, y);
    }

    public void stroke() {
        ctx.stroke();
    }

    public void saveContext() {
        ctx.save();
    }

    public void restoreContext() {
        ctx.restore();
    }

    public void setStrokeStyle(final String rgb) {
        ctx.setStrokeStyle(rgb);
    }

    public void beginPath() {
        ctx.beginPath();
    }

    public void clear() {
        ctx.clearRect(0, 0, canv.getCoordinateSpaceWidth(),
                canv.getCoordinateSpaceHeight());
    }


    public void setGlobalAlpha(final Double alpha) {
        ctx.setGlobalAlpha(alpha);

    }

    public void closePath() {
        ctx.closePath();
    }

    public void setGlobalCompositeOperation(final String mode) {
        ctx.setGlobalCompositeOperation(mode);
    }

    public void setGradientFillStyle(final CanvasGradient gradient) {
        ctx.setFillStyle(gradient);
    }

    public CanvasGradient createLinearGradient(final Double x0, final Double y0, final Double x1,
                                     final Double y1) {
        return ctx.createLinearGradient(x0, y0, x1, y1);
    }

    public CanvasGradient createRadialGradient(final Double x0, final Double y0, final Double r0,
                                     final Double x1, final Double y1, final Double r1) {
        return ctx.createRadialGradient(x0, y0, r0, x1, y1, r1);
    }

    public void setGradientStrokeStyle(final CanvasGradient gradient) {
        ctx.setStrokeStyle(gradient);
    }

    protected void addRpc(CanvasServerRpc rpc){
        this.rpc = rpc;
    }

    protected float getDistance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    protected void startDrawingLine(int clientX, int clientY) {
        x = clientX - canv.getAbsoluteLeft() + Window.getScrollLeft();
        y = clientY - canv.getAbsoluteTop() + Window.getScrollTop();
    }

    protected void endDrawingLine(int clientX, int clientY){
        Line line = new Line(x, y, clientX, clientY, color);
        rpc.addItem(line);
    }

    protected void startDrawingPoint(int clientX, int clientY) {
        Point point = new Point(clientX, clientY, color);
        rpc.addItem(point);
    }

    protected void startDrawingCurve(int clientX, int clientY) {
        x = clientX - canv.getAbsoluteLeft() + Window.getScrollLeft();
        y = clientY - canv.getAbsoluteTop() + Window.getScrollTop();
    }

    protected void continueDrawingCurve(int clientX, int clientY) {
        int newX = clientX - canv.getAbsoluteLeft() + Window.getScrollLeft();
        int newY = clientY - canv.getAbsoluteTop() + Window.getScrollTop();

        if (getDistance(x, y, newX, newY) > dist_buffer) {
            ctx.beginPath();
            ctx.setLineWidth(5);
            ctx.setStrokeStyle(color);
            ctx.moveTo(x, y);
            ctx.lineTo(newX, newY);
            ctx.moveTo(newX, newY);
            ctx.closePath();
            ctx.stroke();
            points.add(new Point(x, y, color));
            (points.get(points.size() - 1)).draw(this);
            x = newX;
            y = newY;
            if (lastUpdateTime + updateTime < new Date().getTime()) {
                endDrawingCurve(clientX, clientY);
            }
        }
    }

    protected void endDrawingCurve(int clientX, int clientY) {

    }
}
