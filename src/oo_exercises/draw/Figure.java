package oo_exercises.draw;
import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {
    protected int x1, y1, x2, y2,
        xLow, yLow, height, width;
    protected Color color;
    protected boolean filled;

    public void drawFigure(Graphics g){

        //set color to the figures' color
        g.setColor(color);

        //pre-processing of coordinates for drawing, inherited by the different shapes
        if(x1<=x2) {
            xLow = x1;
            width= x2-x1;
        } else {
            xLow = x2;
            width= x1-x2;
        }
        if(y1<=y2) {
            yLow = y1;
            height = y2-y1;
        } else {
            yLow = y2;
            height = y1 - y2;
        }
    }

}
