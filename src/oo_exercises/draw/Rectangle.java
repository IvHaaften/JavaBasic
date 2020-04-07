package oo_exercises.draw;

import java.awt.Graphics;

public class Rectangle extends Figure {

    @Override
    public void draw(Graphics g){
        g.drawRect(x1, y1, x2-x1, y2-y1);
    }

}
