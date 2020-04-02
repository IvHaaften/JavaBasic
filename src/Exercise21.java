
import java.util.Scanner;

public class Exercise21 {
    public static void main(String[] args) {
        //goal:
        /*Write a program that reads a positive integer from the user then finds and
        displays the sum of its digits. For example, if the user enters 3582, the program
        should display 18 (3 + 5 + 8 + 2). */

        //initialise scanner
        Scanner scanner = new Scanner(System.in);

        //ask user for a integer
        System.out.print("Please enter a positive integer : ");
        int fullInteger = scanner.nextInt();

        //create sum variable
        int sum = 0;

        //add each digit to sum
        while(fullInteger>0){
            sum = sum + fullInteger%10;
            fullInteger = fullInteger/10;
        }

        System.out.println("The sum of digits is " + sum);

    }
}
