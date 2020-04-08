package oo_exercises.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Draw extends JFrame implements MouseListener, ActionListener {

    protected List<Figure> figures = new ArrayList<>();
    protected Figure figure;
    private String[] buttonActions = {"save", "open","oval", "rectangle","triangle", "line", "filled" ,"color", "empty"};
    private String[] labels = {"\uD83D\uDD0F","\uD83D\uDCC1","○", "□","◢","━","\t✿", "\uD83C\uDFA8","♻"};
    protected String shape = "oval"; //the shape to be drawn
    protected Color newColor=Color.BLACK;
    protected boolean filled = false;

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
                figure = new Oval();
                break;
            case "triangle":
                figure = new Triangle();
                break;
            case "rectangle":
                figure = new Rectangle();
                break;
            case "line":
                figure = new Line();
                break;
            }
        figure.color = newColor;
        figure.filled =filled;

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
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, buttonActions.length));
        toolBar.add(panel);

        for(int i = 0; i < buttonActions.length; i++){
            JButton button = new JButton(labels[i]);
            button.setActionCommand(buttonActions[i]);
            button.setToolTipText("set "+ buttonActions[i] );
            button.addActionListener(this);
            panel.add(button);
            button.setBackground(Color.decode("#FFFFFF"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd){
            case "save":
                try {
                    // create a new file with an ObjectOutputStream
                    FileOutputStream out = new FileOutputStream("savedDraw");
                    ObjectOutputStream oout = new ObjectOutputStream(out);

                    // write something in the file
                    oout.writeObject(figures);
                    oout.flush();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            case "open":
                try {
                    // create an ObjectInputStream for the file
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savedDraw."));
                    ArrayList<Figure> loadFig = (ArrayList<Figure>)ois.readObject();

                    // read and print an object and cast it as string
                    figures.clear();
                    figures.addAll(loadFig);
                    repaint();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                break;
            case "color":
                newColor = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
                ((JButton) e.getSource()).setForeground(newColor);
                //sets new color from colour picker to be the color of the symbol.
                break;
            case "oval":
                shape = "oval";
                break;
            case "rectangle":
                shape = "rectangle";
                break;
            case "triangle":
                shape = "triangle";
                break;
            case "line":
                shape = "line";
                break;
            case "filled":
                if(filled){
                    ((JButton) e.getSource()).setText("✿");
                }else{
                    ((JButton) e.getSource()).setText("❀");
                }
                filled = !filled;

                break;
            case "empty":
                figures.clear();
                repaint();
                break;
            default:
                System.out.println("button has no function");
        }

    }
}
