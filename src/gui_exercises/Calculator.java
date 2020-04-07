package gui_exercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    //goal:
    //create a basic calculator with 16 buttons and a display.
    //10 digits, C, =, /, *, -, +,

    //initialise display
    JLabel display = new JLabel("");

    //Set defaults for stored variables
    String operator;
    int firstNumber = 0;
    int secondNumber = 0;

    //constructor of the calculator
    public Calculator(){
        //set some graphical fluff
        this.setTitle("gui_exercises.Calculator");
        display.setPreferredSize(new Dimension(400, 30));
        display.setFont(new Font("Arial", Font.PLAIN, 25));
        display.setForeground(Color.decode("#00CC00"));

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
            button.setBackground(Color.decode("#FFFF99"));
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
        //store the text of the currentButton to currentButton
        String currentButton = e.getActionCommand();

        //add some functionality to the buttons with switch statements
        switch(currentButton){
            //a number was pressed
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                display.setText(display.getText() + currentButton);
                break;
            //an operator was pressed
            case "/": case "*": case "+": case "-":
                //store the operator and the first number
                operator = currentButton;
                firstNumber = Integer.parseInt(display.getText());
                //clear the display
                display.setText("");
                break;

            //C or reset was pressed
            case "C":
                //set all stored variables to 0/empty
                firstNumber=secondNumber=0;
                display.setText("");
                break;

            //calculator state: the = was pressed
            case "=":
                secondNumber = Integer.parseInt(display.getText());
                int result = 0;

                //now do the calculation dependent on the stored operator
                switch (operator){
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = firstNumber / secondNumber;
                        break;
                    default:
                        System.out.println("System Error: somehow entered an unexpected operator");
                }
                //display the newly calculated result
                display.setText(result + "");
                break;

            default:
                System.out.println("System Error: unexpected input");
        }
    }
}
