import java.util.Scanner;

public class Exercise25 {
    public static void main(String[] args) {
        //goal:
        /*Write a program that prompts the user to enter the highest and lowest
        temperatures for the 12 months of a year. Store the input values in two lists. */

        //initialise scanner
        Scanner scanner = new Scanner(System.in);

        //create lists
        int[] lowestValues = new int[12];
        int[] highestValues = new int[12];

        //prompt user
        System.out.println("Please enter the following variables : ");

        //
        for(int i =0; i<12; i++){
            System.out.print("The lowest temperature value for month " + (i+1) + " : ");
            lowestValues[i] = scanner.nextInt();
            System.out.print("The highest temperature value for month " + (i+1) + " : ");
            highestValues[i] = scanner.nextInt();
        }
    }
}
