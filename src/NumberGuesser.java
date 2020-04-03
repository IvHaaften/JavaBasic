import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuesser extends JFrame implements ActionListener {
    //goal
    /*Computer has a number (rand 0-1000) in mind and the user has to guess it*/

    //generate the random number
    Random random = new Random();
    int bound = 1000; //please set this to the upper bound
    int randomNumber = random.nextInt(bound);

    //set a couple of variables that need to be stored
    JLabel display = new JLabel("Guess a number (0 - "+ bound + ")");


    //constructor for the NumberGuesser
    public NumberGuesser(){
        //set some graphical fluff
        this.setTitle("Number guessing game");
        display.setPreferredSize(new Dimension(600, 100));
        display.setFont(new Font("Arial", Font.PLAIN, 30));
        display.setForeground(Color.decode("#00CC00"));

        //setting the labels of our buttons
        String[] labels =
                {"0", "1", "2", "3", "4", "C",
                "5", "6", "7", "8", "9", "Enter"};

        //adding the display to the content pane
        getContentPane().add(display, BorderLayout.NORTH);

        //create panel for all our buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,6));
        getContentPane().add(panel, BorderLayout.CENTER);

        //creating the 12 buttons
        for(int i = 0; i<12; i++){
            JButton button = new JButton(labels[i]);
            button.setBackground(Color.decode("#FFFF99"));
            panel.add(button);
            button.addActionListener(this);
        }
    }

    public static void main(String[] args) {
        //Call the NumberGuesser function, create a 400x400 calculator
        NumberGuesser guess = new NumberGuesser();
        guess.setSize(600, 300);

        //make visible as a last step, after al graphics are created
        guess.setVisible(true);
        guess.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentButton = e.getActionCommand();

        //add some functionality to the buttons with switch statements
        switch (currentButton){
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                if(!display.getText().equals("Try Again")&&
                        !display.getText().equals("Correct! Number is reset") &&
                                !display.getText().equals("Guess a number (0 - "+ bound + ")")) {
                    display.setText(display.getText() + currentButton);
                }else{
                    display.setText("" + currentButton);
                }
                break;
            //C or reset was pressed
            case "C":
                //set all stored variables to 0/empty
                display.setText("");
                break;
            // When user wants to check the number
            case "Enter":
                int chosenNumber = Integer.parseInt(display.getText());
               if(chosenNumber==randomNumber){
                    //the user won, reset number
                   display.setText("Correct! Number is reset"+"");
                   randomNumber = random.nextInt(bound);
                } else {display.setText("Try Again"+"");}
               break;
            default:
                System.out.println("System Error: Unknown Button");
        }
    }
}
