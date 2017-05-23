package org.test.client;


import com.vaadin.shared.communication.ClientRpc;
import org.test.client.item.Item;
import org.test.client.item.ItemContainer;

public interface CanvasClientRpc extends ClientRpc {
    void drawImage1(String url, Double offsetX, Double offsetY);

    void drawImage2(String url, Double offsetX, Double offsetY,
                           Double imageWidth, Double imageHeight);

    void drawImage3(String url, Double sourceX, Double sourceY,
                           Double sourceWidth, Double sourceHeight, Double destX,
                           Double destY, Double destWidth, Double destHeight);

    void fill();

    void fillRect(Double startX, Double startY, Double rectWidth,
                         Double rectHeight);

    void fillText(String text, Double x, Double y, Double maxWidth);

    void setFont(String font);

    void setTextBaseline(String textBaseline);

    void lineTo(Double x, Double y);

    void moveTo(Double x, Double y);

    void quadraticCurveTo(Double cpx, Double cpy, Double x, Double y);

    void bezierCurveTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y);

    void rect(Double startX, Double startY, Double rectWidth,
                     Double rectHeight);

    void rotate(Double angle);

    void setFillStyle(String color);

    void setLineCap(String lineCap);

    void setLineJoin(String lineJoin);

    void setLineWidth(Double width);

    void setMiterLimit(Double miterLimit);

    void strokeRect(Double startX, Double startY, Double strokeWidth,
                           Double strokeHeight);

    void transform(Double m11, Double m12, Double m21, Double m22,
                          Double dx, Double dy);

    void arc(Double x, Double y, Double radius, Double startAngle,
                    Double endAngle, Boolean antiClockwise);

    void translate(Double x, Double y);

    void scale(Double x, Double y);

    void stroke();

    void saveContext();

    void restoreContext();

    void setStrokeStyle(String rgb);

    void beginPath();

    void clear();

    void setGlobalAlpha(Double alpha);

    void closePath();

    void setGlobalCompositeOperation(String mode);

    void setGradientFillStyle(String gradient);

    void createLinearGradient(String name, Double x0, Double y0,
                                     Double x1, Double y1);

    void createRadialGradient(String name, Double x0, Double y0,
                                     Double r0, Double x1, Double y1, Double r1);

    void setGradientStrokeStyle(String gradient);

    void addColorStop(String gradient, Double offset, String color);

    void loadImages(String[] urls);

    void addItem(Item item);

    void startDrawLines(String color, int thickness);

    void startDrawCurves(String color, int thickness);

    void startDrawRectangles(String color, int thickness);

    void startDrawCubicBezier(String color, int thickness);

    void startDrawQuadBezier(String color, int thickness);

    void startDrawPoints(String color, int thickness);

    void endDraw();

    void setCanvSizes(int width, int height);

    void setCanvWidth(int width);

    void setCanvHeight(int height);
}
