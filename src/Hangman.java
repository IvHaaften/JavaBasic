import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Hangman extends JFrame implements ActionListener {
    String [] secretWordsList =   //choose secret word from these
            {"geography", "cat", "yesterday", "java", "truck", "opportunity",
                    "fish", "token", "transportation", "bottom", "apple", "cake",
                    "remote", "boots", "terminology", "arm", "cranberry", "tool",
                    "caterpillar", "spoon", "watermelon", "laptop", "toe", "toad",
                    "fundamental", "capitol", "garbage", "anticipate", "pesky"};
    //initialise random number generator
    Random random = new Random();
    int bound = secretWordsList.length;

    //set the default number of lives (is also used in reset)
    int defaultLives = 10;

    //set values to default (can be taken on by resetGame() if all works;
    int currentLives = defaultLives;

    ArrayList<String> guessedLetters = new ArrayList<>();
    ArrayList<String> guessedWords = new ArrayList<>();

    int randomNumber = random.nextInt(bound);
    String actualWord = secretWordsList[randomNumber];
    StringBuilder displayWord = new StringBuilder();

    boolean lost = false;
    boolean won = false;

    //create the graphical variables
    //create the two panels
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();

    //create the buttons and displays
    JTextField textField = new JTextField();
    JLabel liveDisplay = new JLabel("You have "+ currentLives + " lives remaining.");
    JLabel wordDisplay = new JLabel("");
    JLabel guessedLetterDisplay = new JLabel("");
    JLabel guessedWordDisplay = new JLabel("");
    JButton resetButton =  new JButton("Reset");

    //constructor
    public Hangman(){
        displayWord.append("-".repeat(actualWord.length()));
        wordDisplay.setText(displayWord.toString());

        //graphical construction
        this.setTitle("Hangman");

        //set the word display
        wordDisplay.setFont(new Font("Arial", Font.PLAIN, 30));
        wordDisplay.setOpaque(true);
        wordDisplay.setBackground(Color.decode("#FFFFFF"));
        wordDisplay.setHorizontalAlignment(JLabel.CENTER);

        //live display
        liveDisplay.setFont(new Font("Arial", Font.PLAIN, 15));
        liveDisplay.setOpaque(true);
        liveDisplay.setBackground(Color.decode("#FFFFFF"));
        liveDisplay.setHorizontalAlignment(JLabel.CENTER);

        //text input
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("Arial", Font.PLAIN, 15));

        //letter display
        guessedLetterDisplay.setFont(new Font("Arial", Font.PLAIN, 15));
        guessedLetterDisplay.setOpaque(true);
        guessedLetterDisplay.setBackground(Color.decode("#FFFFFF"));
        guessedLetterDisplay.setHorizontalAlignment(JLabel.CENTER);

        //word display
        guessedWordDisplay.setFont(new Font("Arial", Font.PLAIN, 15));
        guessedWordDisplay.setOpaque(true);
        guessedWordDisplay.setBackground(Color.decode("#FFFFFF"));
        guessedWordDisplay.setHorizontalAlignment(JLabel.CENTER);

        //button
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setForeground(Color.decode("#FFFFFF"));
        resetButton.setBackground(Color.decode("#FF0000"));

        //set the two panels
        leftPanel.setLayout(new GridLayout(3,1));
        leftPanel.setPreferredSize(new Dimension(450, 300));
        getContentPane().add(leftPanel, BorderLayout.CENTER);
        leftPanel.add(wordDisplay);
        leftPanel.add(liveDisplay);
        leftPanel.add(textField);
        textField.addActionListener(this);

        rightPanel.setLayout(new GridLayout(3,1));
        rightPanel.setPreferredSize(new Dimension(150, 300));
        getContentPane().add(rightPanel, BorderLayout.EAST);
        rightPanel.add(guessedWordDisplay);
        rightPanel.add(guessedLetterDisplay);
        rightPanel.add(resetButton);
        resetButton.addActionListener(this);

    }

    //Function that can set or reset the game
    public void resetGame(){
        //set lives back to default
        lost = false;
        won = false;
        currentLives = defaultLives;
        liveDisplay.setText("You have "+ currentLives + " lives remaining." + "");

        guessedLetters.clear();
        guessedWords.clear();

        guessedWordDisplay.setText("" + "");
        guessedLetterDisplay.setText("" + "");

        //reset word using random number generator
        randomNumber = random.nextInt(bound);
        actualWord = secretWordsList[randomNumber];

        //reset displayWord
        displayWord.delete(0, displayWord.length());
        displayWord.append("-".repeat(actualWord.length()));
        wordDisplay.setText(displayWord.toString());
    }

    public static void main(String[] args) {
        //Call the game function
        Hangman hangman = new Hangman();
        hangman.setSize(600, 300);

        //make visible as a last step, after al graphics are created
        hangman.setVisible(true);
        hangman.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Reset")){
            resetGame();
        }
        if(!lost && !won){
            String currentInput = textField.getText();
            int lengthInput = currentInput.length();

            if (lengthInput == 1) {
                //only a single character was entered.
                //test character in word
                if (actualWord.contains(currentInput)) {
                    //letter is in word
                    for(int i = 0; i<actualWord.length(); i++){
                        if(String.valueOf(actualWord.charAt(i)).equals(currentInput)){
                            displayWord.setCharAt(i, currentInput.charAt(0));
                        }
                    }
                    wordDisplay.setText(displayWord.toString());

                    if(displayWord.toString().equals(actualWord)){
                        //all letters were guessed
                        liveDisplay.setText("You win! Hit reset to play again.");
                        won=true;
                    }

                } else {
                    //no match in the word
                    //only lose a life if the letter has not been entered before
                    if(!guessedLetters.contains(currentInput)){
                        currentLives = currentLives-1;
                        if (currentLives<1){
                            lost = true;
                            liveDisplay.setText("Out of lives. Please hit reset to play again.");
                        } else {
                            liveDisplay.setText("Incorrect. You have "+ currentLives + " lives remaining.");

                            guessedLetters.add(currentInput);

                            StringBuilder letterDisplay = new StringBuilder();

                            for (String guessedLetter : guessedLetters) {
                                letterDisplay.append(guessedLetter).append(", ");
                            }
                            guessedLetterDisplay.setText(letterDisplay + "");
                        }
                    }
                }

            } else if(lengthInput>=1){
                //a word was entered.
                if(currentInput.equals(actualWord)){
                    //win
                    wordDisplay.setText(actualWord);
                    liveDisplay.setText("You win! Hit reset to play again.");
                    won=true;
                } else {
                    //incorrect
                    currentLives = currentLives-1;

                    if(currentLives<1){
                        lost = true;
                        liveDisplay.setText("Out of lives. Please hit reset to play again.");
                    }else{
                        liveDisplay.setText("Incorrect. You have "+ currentLives + " lives remaining.");

                        guessedWords.add(currentInput);

                        StringBuilder wordDisplay = new StringBuilder();

                        for (String guessedWord : guessedWords) {
                            wordDisplay.append(guessedWord).append(", ");
                        }
                        guessedWordDisplay.setText(wordDisplay + "");
                    }


                }
            }
        } else {
            if(lost)liveDisplay.setText("Out of lives. Please hit reset to play again.");
            if(won)liveDisplay.setText("You win! Hit reset to play again.");
        }
        textField.setText("");
    }
}
