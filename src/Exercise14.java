public class Exercise14 {
    public static void main(String[] args) {
        //goal
        /*14.Write a program that calculates and displays the sum of all integers between 1
        and 20. */

        //initialise sum variable
        int sum = 0;

        //loop all integers between 1 and 20
        for(int i=0; i<20; i++){
            sum = sum + i + 1;
        }
        System.out.println("The sum of all integers between 1 and 20 is : " + sum);
    }
}
