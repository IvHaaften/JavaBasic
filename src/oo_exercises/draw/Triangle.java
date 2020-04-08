package oo_exercises.draw;

import java.awt.*;

public class Triangle extends Figure {
    int x3, y3;

    @Override
    public void draw(Graphics g) {
        super.draw(g);


        if((y1==yLow && x1==xLow)||(y2==yLow && x2==xLow)){
            //	◣
            x3 = xLow;
        } else {
            //◢
            x3 = xLow+width;
        }

        y3 = yLow+height;

        int [] xPoints = {x1, x2, x3};
        int [] yPoints = {y1, y2, y3};

        if(filled){
            g.fillPolygon(xPoints, yPoints, xPoints.length);
        }else{
            g.drawPolygon(xPoints, yPoints, xPoints.length);
        }
    }
}
