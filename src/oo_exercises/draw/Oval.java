package oo_exercises.draw;

import java.awt.Graphics;

public class Oval extends Figure{

    @Override
    public void drawFigure(Graphics g){
        super.drawFigure(g);

        if(filled){
            g.fillOval(xLow, yLow, width, height);
        }else{
            g.drawOval(xLow, yLow, width, height);
        }

    }

}
