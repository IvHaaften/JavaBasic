import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        //goal:
        /*Write a program that asks the user to enter a temperature in degrees Celsius. The
        program will convert the temperature to degrees Fahrenheit and display the
        result to the user with an appropriate message. (Hint: F° = (1.8 × C°) + 32.) */
        //initialising scanner
        Scanner scanner = new Scanner(System.in);

        //asking for the desired input
        System.out.print("Please enter a temperature in degrees Celsius (please use a , as decimal seperator) : ");
        double celsius = scanner.nextDouble();
        double fahrenheit = (1.8*celsius)+32;
        System.out.println(celsius + " degrees celsius is equal to " + fahrenheit + " degrees Fahrenheid");
        
    }
}
