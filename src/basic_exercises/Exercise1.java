package basic_exercises;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        //goals
        /* Write a program that asks that user to enter an article, a noun, and a verb. The
        program then creates a sentence of the form article noun verb. */

        //initialising scanner
        Scanner scanner = new Scanner(System.in);

        //asking for the desired input
        System.out.print("Please enter an article (the or a/an): ");
        String article = scanner.nextLine();

        System.out.print("Please enter a noun (eg. chair, desk, or table): ");
        String noun = scanner.nextLine();

        System.out.print("Please enter a verb in the tense present simple (eg. walks, talks, or pushes): ");
        String verb = scanner.nextLine();

        //desired output
        System.out.println(article + " " + noun + " " + verb + ".");

    }
}
