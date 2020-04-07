package oo_exercises.draw;

import java.awt.Graphics;

public class Rectangle extends Figure {

    @Override
    public void draw(Graphics g){
        super.draw(g);
        g.drawRect(xLow, yLow, width, height);
    }

}
