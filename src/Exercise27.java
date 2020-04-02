import java.util.ArrayList;
import java.util.Random;

public class Exercise27 {
    public static void main(String[] args) {
        //goal:
        /*Write a program that processes a list of 20 scores on a test with 100 items and
        finds the number of students who scored between 85 and 90. */

        ArrayList<Integer> testScores = new ArrayList<>();

        //counter for the number of students
        int countScores = 0;

        //initialise random number generator;
        Random random = new Random();
        for (int i=0; i<20; i++){
            testScores.add(i, random.nextInt(100));
            if(testScores.get(i)>=85 && testScores.get(i)<=90){
                countScores++;
            }
        }
        System.out.println("There was/were " + countScores + " student(s) with a score between 85 and 90.");

    }
}
