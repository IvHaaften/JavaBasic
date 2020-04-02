public class Exercise16 {
    public static void main(String[] args) {
        //goal:
        /*Write a program that displays the first 10 numbers in the following sequence:
            5, 9, 13, 17, 21, .... */

        //setting the first number of the sequence
        int number = 5;
        System.out.print("The sequence is : " + 5);

        for(int i=0; i<9; i++){
            number = number + 4;
            System.out.print(", " + number);
        }
    }
}
