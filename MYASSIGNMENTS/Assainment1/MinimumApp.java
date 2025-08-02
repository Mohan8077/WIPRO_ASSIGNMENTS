package Assainment1;
import java.util.Scanner;

@FunctionalInterface
interface MinimumFinder {
    double find(double a, double b, double c);
}

public class MinimumApp {
    
    // Static method to find the minimum of 3 values using Math.min
    public static double minimum3(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read three floating-point numbers
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        System.out.print("Enter third number: ");
        double num3 = scanner.nextDouble();

        // Use method reference to assign method to functional interface
        MinimumFinder minFinder = MinimumApp::minimum3;

        // Find the minimum value
        double result = minFinder.find(num1, num2, num3);
        
        // Display the result
        System.out.println("The smallest value is: " + result);

        scanner.close();
    }
}