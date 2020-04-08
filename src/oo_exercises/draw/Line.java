package oo_exercises.draw;

import java.awt.*;

public class Line extends Figure {

    @Override
    public void drawFigure(Graphics g) {
        super.drawFigure(g);

        g.drawLine(x1, y1, x2, y2);
    }
}
