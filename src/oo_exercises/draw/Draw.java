package oo_exercises.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Draw extends JFrame implements MouseListener {

    List<Figure> figures = new ArrayList<>();
    Figure figure;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Figure f : figures){
            f.draw(g);
        }
    }

    public Draw() throws HeadlessException{
        this.addMouseListener(this);
    }

    public static void main(String[] args) {
        Draw draw = new Draw();
        draw.setSize(500, 500);
        draw.setVisible(true);
        draw.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()){
            case 1:
                //left mouse button
                figure = new Rectangle();
                break;
            case 3:
                //right mouse button
                figure = new Oval();
                break;

        }

        figure.x1 = e.getX();
        figure.y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        figure.x2 = e.getX();
        figure.y2 = e.getY();
        figures.add(figure);
        repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
