import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        //goal:
        /*A company sells five different products whose retail prices are shown in the
        following table. Write a program that asks the user to enter the product number
        and the quantity sold. The program will then calculate and display the total
        retail value.
        product number retail price
        1 2.95
        2 4.99
        3 5.49
        4 7.80
        5 8.85*/

        //initialising scanner
        Scanner scanner = new Scanner(System.in);

        //interaction with user
        System.out.print("Please enter the desired product number : ");
        int number = scanner.nextInt();
        System.out.print("Please enter the quantity sold : ");
        int quantity = scanner.nextInt();

        //switch for different outcomes
        switch(number){
            case 1:
                System.out.println(quantity*2.95 + " worth of product was sold.");
                break;
            case 2:
                System.out.println(quantity*4.99 + " worth of product was sold.");
                break;
            case 3:
                System.out.println(quantity*5.49 + " worth of product was sold.");
                break;
            case 4:
                System.out.println(quantity*7.80 + " worth of product was sold.");
                break;
            case 5:
                System.out.println(quantity*8.85 + " worth of product was sold.");
                break;
            default:
                System.out.println("Entered invalid product code.");
        }
    }
}
