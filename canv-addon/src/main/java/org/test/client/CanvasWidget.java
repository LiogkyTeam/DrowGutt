package org.test.client;

import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;


import java.util.ArrayList;
import java.util.List;

// Extend any GWT Widget
public class CanvasWidget extends VerticalPanel {
    final com.google.gwt.canvas.client.Canvas canv;
    private Context2d ctx;

    public CanvasWidget(){
        canv = com.google.gwt.canvas.client.Canvas.createIfSupported();
        add(canv);
        ctx = canv.getContext2d();

        setStyleName("widget");
    }

    public void addMouseMoveHandler(MouseMoveHandler handler){
        canv.addMouseMoveHandler(handler);
    }

    public void addMouseUpHandler(MouseUpHandler handler){
        canv.addMouseUpHandler(handler);
    }

    public void addMouseDownHandler(MouseDownHandler handler){
        canv.addMouseDownHandler(handler);
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

}
