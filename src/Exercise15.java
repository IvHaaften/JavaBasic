public class Exercise15 {
    public static void main(String[] args) {
        //goal:
        /*Write a program that calculates and displays the sum of all odd integers
        between 1 and 20. */

        //initialise sum variable
        int sum = 0;

        //loop all integers between 1 and 20
        for(int i=0; i<20; i++){
            //if the current integer is not dividable by 2 without remainders add it to the rest.
            if((i+1)%2 != 0){
            sum = sum + i + 1;}
        }
        System.out.println("The sum of all odd integers between 1 and 20 is : " + sum);
    }
}
