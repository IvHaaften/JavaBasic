package basic_exercises;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        //goal:
        /*Express each of the following statements using an if block:
        a.If x divided by y is 5, then set x to 100.
        b.If x times y is 5, then set x to 1.
        c.If x is less than y, then double the value of x.
        d.If x is greater than y, then increment the value of x by 1.*/

        //initialising scanner
        Scanner scanner = new Scanner(System.in);
        //asking for the desired input
        System.out.print("Please enter an integer to define x : ");
        int x = scanner.nextInt();
        System.out.print("Please enter an integer to define y : ");
        int y = scanner.nextInt();

        if((x/y)==5){
            x=100;
        }
        if(x*y==5){
            x=1;
        }
        if(x<y){
            x=x*2;
        }
        if(x>y){
            x++;
        }
        System.out.println("x is currently " + x);

        //the exercise did not specify if only one case should apply or if they should be checked in turn
    }
}
