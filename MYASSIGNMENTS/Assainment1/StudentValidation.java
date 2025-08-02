package Assainment1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentValidation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            // Read inputs
            System.out.print("Enter Register Number: ");
            String regNo = sc.nextLine();

            System.out.print("Enter Mobile Number: ");
            String mobileNo = sc.nextLine();

            // Validate Register Number
            if (regNo.length() != 9) {
                throw new IllegalArgumentException("Register Number must be exactly 9 characters.");
            }
            if (!regNo.matches("[a-zA-Z0-9]+")) {
                throw new NoSuchElementException("Register Number must contain only alphabets and digits.");
            }

            // Validate Mobile Number
            if (mobileNo.length() != 10) {
                throw new IllegalArgumentException("Mobile Number must be exactly 10 digits.");
            }
            if (!mobileNo.matches("\\d+")) {
                throw new NumberFormatException("Mobile Number must contain only digits.");
            }

            // If all checks passed
            System.out.println("valid");

        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("invalid");
        }

        sc.close();
    }
}