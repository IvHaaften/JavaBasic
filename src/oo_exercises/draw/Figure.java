package oo_exercises.draw;
import java.awt.Graphics;

public abstract class Figure {
    protected int x1, y1, x2, y2,
        xLow, yLow, height, width;

    public void draw(Graphics g){
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
