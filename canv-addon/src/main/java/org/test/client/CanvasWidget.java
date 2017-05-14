package org.test.client;

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
    private final List<Command> commands;

    public CanvasWidget(){
        commands = new ArrayList<Command>();
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

    private Context2d ctx;

    public void runCommand(Command command) {
        if (commands.add(command))
            command.execute();
    }

    public void clearCommands() {
        commands.clear();
    }

    public void fillRect(final Double startX, final Double startY,
                         final Double width, final Double height) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.fillRect(startX, startY, width, height);
            }
        });
    }

    public void drawImage1(final String url, final Double offsetX,
                           final Double offsetY) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.drawImage(
                        ImageElement.as(new Image(url).getElement()),
                        offsetX, offsetY);
            }
        });
    }

    public void drawImage2(final String url, final Double offsetX,
                           final Double offsetY, final Double imageWidth,
                           final Double imageHeight) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.drawImage(
                        ImageElement.as(new Image(url).getElement()),
                        offsetX, offsetY, imageWidth, imageHeight);
            }
        });
    }

    public void drawImage3(final String url, final Double sourceX,
                           final Double sourceY, final Double sourceWidth,
                           final Double sourceHeight, final Double destX,
                           final Double destY, final Double destWidth,
                           final Double destHeight) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.drawImage(
                        ImageElement.as(new Image(url).getElement()),
                        sourceX, sourceY, sourceWidth, sourceHeight,
                        destX, destY, destWidth, destHeight);
            }
        });
    }

    public void fill() {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.fill();
            }
        });
    }

    public void fillText(final String text, final Double x,
                         final Double y, final Double maxWidth) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.fillText(text, x, y, maxWidth);
            }
        });
    }

    public void setFont(final String font) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.setFont(font);
            }
        });
    }

    public void setTextBaseline(final String textBaseline) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.setTextBaseline(textBaseline);
            }
        });
    }

    public void lineTo(final Double x, final Double y) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.lineTo(x, y);
            }
        });
    }

    public void moveTo(final Double x, final Double y) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.moveTo(x, y);
            }
        });
    }

    public void quadraticCurveTo(final Double cpx, final Double cpy,
                                 final Double x, final Double y) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.quadraticCurveTo(cpx, cpy, x, y);
            }
        });
    }

    public void bezierCurveTo(final double cp1x, final double cp1y,
                              final double cp2x, final double cp2y, final double x,
                              final double y) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.bezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y);
            }
        });
    }

    public void rect(final Double startX, final Double startY,
                     final Double rectWidth, final Double rectHeight) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.rect(startX, startY, rectWidth, rectHeight);
            }
        });
    }

    public void rotate(final Double angle) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.rotate(angle);
            }
        });
    }

    public void setFillStyle(final String color) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.setFillStyle(color);
            }
        });
    }

    public void setLineCap(final String lineCap) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.setLineCap(lineCap);
            }
        });
    }

    public void setLineJoin(final String lineJoin) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.setLineJoin(lineJoin);
            }
        });
    }

    public void setLineWidth(final Double lineWidth) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.setLineWidth(lineWidth);
            }
        });
    }

    public void setMiterLimit(final Double miterLimit) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.setMiterLimit(miterLimit);
            }
        });
    }

    public void strokeRect(final Double startX, final Double startY,
                           final Double strokeWidth, final Double strokeHeight) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.strokeRect(startX, startY, strokeWidth,
                        strokeHeight);
            }
        });
    }

    public void transform(final Double m11, final Double m12,
                          final Double m21, final Double m22, final Double dx,
                          final Double dy) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.transform(m11, m12, m21, m22, dx, dy);
            }
        });
    }

    public void arc(final Double x, final Double y,
                    final Double radius, final Double startAngle,
                    final Double endAngle, Boolean antiClockwise) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.arc(x, y, radius, startAngle, endAngle);
            }
        });
    }

    public void translate(final Double x, final Double y) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.translate(x, y);
            }
        });
    }

    public void scale(final Double x, final Double y) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.scale(x, y);
            }
        });
    }

    public void stroke() {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.stroke();
            }
        });
    }

    public void saveContext() {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.save();
            }
        });
    }

    public void restoreContext() {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.restore();
            }
        });
    }

    public void setStrokeStyle(final String rgb) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.setStrokeStyle(rgb);
            }
        });
    }

    public void beginPath() {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.beginPath();
            }
        });
    }

    public void clear() {
        ctx.clearRect(0, 0, canv.getCoordinateSpaceWidth(),
                canv.getCoordinateSpaceHeight());
        clearCommands();
    }


    public void setGlobalAlpha(final Double alpha) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.setGlobalAlpha(alpha);
            }
        });
    }

    public void closePath() {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.closePath();
            }
        });
    }

    public void setGlobalCompositeOperation(final String mode) {
        runCommand(new Command() {
            @Override
            public void execute() {
                ctx.setGlobalCompositeOperation(mode);
            }
        });
    }

}
