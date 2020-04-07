package oo_exercises.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Draw extends JFrame implements MouseListener, ActionListener {

    List<Figure> figures = new ArrayList<>();
    Figure figure;
    String[] shapes = {"oval", "rectangle", "line"};
    String shape = "oval"; //the shape to be drawn

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Figure f : figures){
            f.draw(g);
        }
    }

    public Draw() throws HeadlessException{
        this.getContentPane().setBackground(Color.decode("#FFFFFF"));
        this.addMouseListener(this);

        JToolBar toolBar = new JToolBar("Toolbar");
        addButtons(toolBar);
        add(toolBar, BorderLayout.PAGE_START);
    }

    public static void main(String[] args) {
        Draw draw = new Draw();
        draw.setSize(500, 500);
        draw.setVisible(true);
        draw.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (shape){
            case "oval":
                //left mouse button
                figure = new Oval();
                break;
            case "rectangle":
                //right mouse button
                figure = new Rectangle();
                break;
            case "line":
                //button 4
                figure = new Line();
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

    protected void addButtons(JToolBar toolBar) {


        for(String shapes : shapes){
            JButton button = new JButton(shapes);
            button.setActionCommand(shapes);
            button.setToolTipText("draws an "+ shapes + " on click");
            button.addActionListener(this);
            toolBar.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd){
            case "oval":
                shape = "oval";
                break;
            case "rectangle":
                shape = "rectangle";
                break;
            case "line":
                shape = "line";
                break;
            default:
                System.out.println("test default");
        }

    }
}
