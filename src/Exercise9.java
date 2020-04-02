import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        //goal:
        /*.Create an input validation loop that only accepts numbers in the range of 1
        through 10.*/

        //initialising scanner
        Scanner scanner = new Scanner(System.in);

        //set default value
        double input = 0;

        //as long as there is no input between 1 and 10, loop
        while(input < 1 || input > 10){
            System.out.print("Please enter a number between 1 and 10 : ");
            input = scanner.nextInt();
        }

        System.out.println("You successfully entered a number between 1 and 10");

    }
}
