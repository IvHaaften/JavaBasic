import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    //goal:
    //create a basic calculator with 16 buttons and a display.
    //10 digits, C, =, /, *, -, +,

    //initialise display
    JLabel display = new JLabel("Display");

    //constructor of the calculator
    public Calculator(){
        //setting the labels of our buttons
        String[] labels =
                {
                        "7", "8", "9", "/",
                        "4", "5", "6","*",
                        "1", "2", "3", "+",
                        "C", "0", "=", "-" };

        //adding the display to the content pane
        getContentPane().add(display, BorderLayout.NORTH);

        //create panel for all our buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        getContentPane().add(panel, BorderLayout.CENTER);

        //creating the 16 buttons
        for(int i = 0; i<16; i++){
            JButton button = new JButton(labels[i]);
            panel.add(button);
            button.addActionListener(this);
        }
    }

    public static void main(String[] args) {
        //Call the calculator function, create a 400x400 calculator
        Calculator calculator = new Calculator();
        calculator.setSize(400, 400);

        //make visible as a last step, after al graphics are created
        calculator.setVisible(true);
        calculator.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //the text on the clicked button is printed
        String currentButton = e.getActionCommand();
        System.out.println(currentButton);
    }
}
