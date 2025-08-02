package Assainment1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Handle InputMismatchException
        try {
            System.out.print("Enter an integer: ");
            int number = Integer.parseInt(scanner.nextLine()); // safer than nextInt()
            System.out.println("You entered: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught InputMismatchException: Please enter a valid integer.");
        }

        // Handle StringIndexOutOfBoundsException
        try {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            System.out.print("Enter index to access character at: ");
            int index = Integer.parseInt(scanner.nextLine()); // again use nextLine()

            char ch = text.charAt(index); // may throw exception
            System.out.println("Character at index " + index + " is: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: Index is out of bounds.");
        } catch (NumberFormatException e) {
            System.out.println("Caught InputMismatchException: Please enter a valid number for index.");
        }

        scanner.close();
    }
}
