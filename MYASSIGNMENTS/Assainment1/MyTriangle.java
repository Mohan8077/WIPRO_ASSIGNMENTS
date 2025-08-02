package Assainment1;

import java.util.Scanner;

public class MyTriangle {

    // Method to check if the triangle is valid
    public static boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Method to calculate the perimeter
    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    // Method to calculate the area using Heron's formula
    public static double area(double a, double b, double c) {
        double s = perimeter(a, b, c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // Main method to test functionality
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter side a (-1 to exit): ");
            double a = sc.nextDouble();
            if (a == -1) {
                System.out.println("Bye~");
                break;
            }

            System.out.print("Enter side b: ");
            double b = sc.nextDouble();
            System.out.print("Enter side c: ");
            double c = sc.nextDouble();

            if (isValid(a, b, c)) {
                double peri = perimeter(a, b, c);
                double ar = area(a, b, c);
                System.out.printf("Perimeter: %.2f\n", peri);
                System.out.printf("Area: %.2f\n", ar);
            } else {
                System.out.println("The input is invalid.");
            }
        }

        sc.close();
    }
}