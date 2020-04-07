package basic_exercises;

import java.util.Scanner;

public class Exercise23 {
    public static void main(String[] args) {
        //goal:
        /*Create three lists to store personal records. The first list stores names, the
        second list stores birth dates, and the third list stores phone numbers. Write a
        program that asks the user the name of the person whose contact information is
        needed. If the person’s name exists in the first list, the program will say the
        person’s birth date and phone number. */

        Scanner scanner = new Scanner(System.in);

        String[] lastNames = {"Shelley", "Austen", "Poe"};
        String[] birthDates = {"30th of August, 1797", "16th of December, 1775", "19th of January, 1809"};
        String[] phoneNumbers = {"+222 01", "+222 02", "+222 03"};

        System.out.print("Please enter the last name of the person you are looking for : ");
        String searchName = scanner.nextLine();

        switch (searchName) {
            case "Shelley":
                System.out.println("Was born on the " + birthDates[0] + ", and can be reached at the internal number : "+ phoneNumbers[0]);
                break;
            case "Austen":
                System.out.println("Was born on the " + birthDates[1] + ", and can be reached at the internal number : "+ phoneNumbers[1]);
                break;
            case "Poe":
                System.out.println("Was born on the " + birthDates[2] + ", and can be reached at the internal number : "+ phoneNumbers[2]);
                break;
            default:
                System.out.println("The entered name does not appear on the list.");
        }


    }
}
