package oo_exercises.draw;

import java.awt.*;

public class Line extends Figure {

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawLine(x1, y1, x2, y2);
    }
}
