package basic_exercises;

import java.util.Scanner;

public class Exercise8 {

    public static void main(String[] args) {
        //goal:
        /*Write a program that asks the user to enter three numbers. The pro- gram will
        then determine and print the largest of the three numbers. */

        //initialising scanner
        Scanner scanner = new Scanner(System.in);

        //create array for numbers
        int[] numbers = new int[3];

        //ask user for three numbers and add them to array
        for(int i=0; i<3; i++){
            System.out.print("Please enter integer " + (i+1) + " : ");
            numbers[i] = scanner.nextInt();
        }

        //determine largest number and print it.
        if(numbers[0] >= numbers[1] && numbers[0] >= numbers[2]){
            System.out.println("The largest number was " + numbers[0]);
        } else if(numbers[1] >= numbers[0] && numbers[1] >= numbers[2]){
            System.out.println("The largest number was " + numbers[1]);
        } else {
            System.out.println("The largest number was " + numbers[2]);
        }

    }
}
