import java.util.ArrayList;

public class Exercise22 {

    //a function that brute forces if an integer is a prime
    public static boolean PrimeChecker(int number){
        if(number == 0 || number == 1){
            //0 and 1 are no prime numbers and should be skipped
            return false;
        }else {
            //a number cannot be divisible by a number larger than its square root. note: <= as otherwise integers with integer roots are incorrectly labeled as prime
            for(int j = 2; j<=Math.sqrt(number);j++){
                if(number % j ==0){
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        //goal:
        /*Create a list that contains the first 10 prime numbers. */

        //create an array to store the prime numbers
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        //generate the prime numbers within

        //set a variable to use as lower bound for the prime search
        int number = 1;

        //search for primes until there are 10 values in primeNumbers
        while(primeNumbers.size()<10){
            boolean found = false;
            //as long as no prime was found
            while(!found){
                //check if current number is prime, if not, continue to next number until prime is found
                if(PrimeChecker(number)){
                    found = true;
                }else{
                    number++;
                }
            }

            //when a prime number has been selected, add it to the list and start looking dor the next
            primeNumbers.add(number);

            //make sure the search is not started with the current prime
            number++;
        }

        //print the list of found prime numbers
        System.out.print("The first 10 prime numbers are: " + primeNumbers.get(0));
        //note: starts on i=1, so that the printed text works out
        for(int i =1; i<10; i++) {
            System.out.print(", " + primeNumbers.get(i));
        }



    }
}
