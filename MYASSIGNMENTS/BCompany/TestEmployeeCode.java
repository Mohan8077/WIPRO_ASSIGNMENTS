package BCompany;

import java.util.Scanner;

public class TestEmployeeCode {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     try {
         System.out.print("Enter employee name: ");
         String name = scanner.nextLine();

         System.out.print("Enter employee year of birth: ");
         int yearOfBirth = Integer.parseInt(scanner.nextLine());

         System.out.print("Enter employee code (format YY-D-XXX): ");
         String empCode = scanner.nextLine();

         // Try to create Employee object
         Employee emp = new Employee(empCode, name, yearOfBirth);
         System.out.println("\nEmployee details:");
         emp.printDetails();

     } catch (InvalidEmployeeCode e) {
         System.out.println("InvalidEmployeeCode Exception: " + e.getMessage());
     } catch (Exception e) {
         System.out.println("Unexpected error: " + e.getMessage());
     }

     scanner.close();
 }
}
