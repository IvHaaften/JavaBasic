package basic_exercises;

import java.util.Scanner;

public class Exercise19 {
    public static void main(String[] args) {
        //goal:
        /*Write a program that asks the user to enter a word. The program then
        determines the number of occurrences of the letter a in the input word. */

        //initialise scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a word: ");
        String word = scanner.nextLine();
        //make sure all letters are lowercase
        word = word.toLowerCase();

        String[] letterA = word.split("a") ;

        System.out.println("There were " + (letterA.length - 1) + " instances of the letter a in the word " + word);

    }
}
