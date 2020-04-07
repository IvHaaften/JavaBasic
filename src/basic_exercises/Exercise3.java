package basic_exercises;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        //goal:
        /*Write a program that reads the lengths of the two sides of a right triangle and
        calculates the length of the hypotenuse. */

        //initialising scanner
        Scanner scanner = new Scanner(System.in);

        //asking for the two sides of the triangle
        System.out.print("To calculate the length of the hypotenuse, please enter the lengths of the two catheti. " +
                "\n Please enter the length of the first cathetus (use a , as decimal seperator):");
        double cathetus1 = scanner.nextDouble();
        System.out.print("\n Please enter the length of the second cathetus (usSe a , as decimal seperator):");
        double cathetus2 = scanner.nextDouble();
        //solving pythagoras for the entered lengths
        double hypotenuse = Math.sqrt((cathetus1*cathetus1) + (cathetus2 * cathetus2));
        //printing the hypotenuse
        System.out.println("The hypotenuse has a length of " + hypotenuse + ".");
    }
}
