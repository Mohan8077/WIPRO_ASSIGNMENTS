package Assainment1;
import java.util.Scanner;

public class Que4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter your years of service: ");
        int years = sc.nextInt();

        if (years > 6) {
            double bonus = salary * 0.10;
            System.out.println("You are eligible for a bonus of: ₹" + bonus);
        } else {
            System.out.println("You are not eligible for a bonus.");
        }

        sc.close();
    }
}