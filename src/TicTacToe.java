import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    //X is always first
    String currentTurn = "X";
    //at the start the game has not yet been won
    boolean win = false;
    boolean tie = false;

    JLabel display = new JLabel("It is now the turn of "+ currentTurn);
    JPanel panel = new JPanel();

    public void BoardReset(){

            //if the game is won reset board
            for(int i =0; i<9; i++){
                ((JButton) panel.getComponents()[i]).setText("-");
                (panel.getComponents()[i]).setForeground(Color.decode("#000000"));
            }
            win = false;
            tie = false;
            currentTurn = "X";
            display.setText("It is now the turn of " + currentTurn);

    }



    //constructor
    public TicTacToe(){
        //set some graphical fluff
        this.setTitle("Tic Tac Toe");
        display.setPreferredSize(new Dimension(300, 25));
        display.setFont(new Font("Arial", Font.PLAIN, 15));
        display.setForeground(Color.decode("#00CC00"));
        display.setHorizontalAlignment(JLabel.CENTER);

        //adding the display to the content pane
        getContentPane().add(display, BorderLayout.NORTH);

        //create panel for all our buttons
        panel.setLayout(new GridLayout(3,3));
        getContentPane().add(panel, BorderLayout.CENTER);

        //creating the 9 buttons
        for(int i = 0; i<9; i++){
            JButton button = new JButton("-");
            button.setBackground(Color.decode("#ffffbf"));
            button.setFont(new Font("Arial", Font.PLAIN, 35));
            panel.add(button);
            button.addActionListener(this);
        }

    }

    public static void main(String[] args) {
        //Call the NumberGuesser function, create a 400x400 calculator
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.setSize(300, 325);

        //make visible as a last step, after al graphics are created
        ticTacToe.setVisible(true);
        ticTacToe.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentButton = e.getActionCommand();

        switch (currentButton){
            case "-":
                //has past round been won? if so, reset and skip rest of step

                if(win || tie){
                    BoardReset();
                } else {
                    // get the text of the clicked item (is a JButton)
                    ((JButton) e.getSource()).setText(currentTurn);

                    //set blue for one team, orange for the other
                    if(currentTurn.equals("X")){ //reddish orange
                        ((JButton) e.getSource()).setForeground(Color.decode("#fc8d59"));
                    } else { //blueish
                        ((JButton) e.getSource()).setForeground(Color.decode("#91bfdb"));
                    }

                    //check for win & tie
                    WinCheck();

                    TieCheck();

                    //if won, display winner, else change turn
                    if(win){
                        display.setText( currentTurn + " won! Press any button to reset game.");
                    }else if(tie){
                        display.setText( "It's a tie. Press any button to reset game.");
                    }else{
                        //set turn to other value
                        if(currentTurn.equals("X")) {
                                currentTurn="O";
                            } else {
                                    if(currentTurn.equals("O")) {currentTurn="X";}}
                        display.setText("It is now the turn of " + currentTurn);
                    }
                }

                break;
            case "X": case"O":
                if(win || tie) BoardReset();
                break;
            default:
                System.out.println("Pressed nonexistent button");

        }

    }

    public void WinCheck(){
        //Go by the board per row, per column and the 2 diagonals()
        //per row
        for(int i =0; i<3;i++) {
            String first = ((JButton) panel.getComponents()[(i*3)]).getText();
            String second = ((JButton) panel.getComponents()[(i*3)+1]).getText();
            String third = ((JButton) panel.getComponents()[(i*3)+2]).getText();
            if (first.equals(second) && first.equals(third) && !first.equals("-")){
                win = true;
            }
        }

        //per column
        for(int i =0; i<3;i++) {
            String first = ((JButton) panel.getComponents()[(i)]).getText();
            String second = ((JButton) panel.getComponents()[(i)+3]).getText();
            String third = ((JButton) panel.getComponents()[(i)+6]).getText();
            if (first.equals(second) && first.equals(third) && !first.equals("-")){
                win = true;
            }
        }

        //The two diagonals
        String first = ((JButton) panel.getComponents()[0]).getText();
        String second = ((JButton) panel.getComponents()[4]).getText();
        String third = ((JButton) panel.getComponents()[8]).getText();
        if (first.equals(second) && first.equals(third) && !first.equals("-")){
            win = true;
        }
        first = ((JButton) panel.getComponents()[2]).getText();
        //the fourth button is still saved from the past diagonal
        third = ((JButton) panel.getComponents()[8]).getText();
        if (first.equals(second) && first.equals(third) && !first.equals("-")){
            win = true;
        }

    }

    public void TieCheck(){
        tie = true;
        for(int i =0; i<9;i++) {
            String value = ((JButton) panel.getComponents()[i]).getText();
            if (value.equals("-")){
                tie = false;
            }
        }
    }
}
