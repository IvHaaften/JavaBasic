package oo_exercises.draw;

import java.awt.Graphics;

public class Rectangle extends Figure {

    @Override
    public void drawFigure(Graphics g){
        super.drawFigure(g);
        if(filled){
            g.fillRect(xLow, yLow, width, height);
        }else{
            g.drawRect(xLow, yLow, width, height);
        }
    }

}
