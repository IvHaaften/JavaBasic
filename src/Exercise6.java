import java.util.Scanner;

public class Exercise6 {

    public static void main(String[] args) {
        //goal
        /*Write a program that prompts the user to enter five test scores between 1 and 10.
        The program will then count the number of scores that are greater than 7.  */

        //initialising scanner
        Scanner scanner = new Scanner(System.in);

        //create counting variable
        int counter = 0;

        //accept testScores and count each one higher than 7
        for(int i = 0; i<5; i++){
            System.out.print("Please enter test score "+ (i+1) + ": ");
            int testScore = scanner.nextInt();
            if(testScore > 7) {
                counter++;
            }
        }
        //print outcome
        System.out.println("There were " + counter + " score(s) higher than 7.");

    }
}
