package oo_exercises.draw;

import java.awt.Graphics;

public class Oval extends Figure{

    @Override
    public void draw(Graphics g){
        super.draw(g);
        g.drawOval(xLow, yLow, width, height);

    }

}
