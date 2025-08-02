package Assainment1;


public class Que11 {

    void add(int a, int b) {
        int result = a + b;
        System.out.println("Addition: " + result);
    }

    void diff(int a, int b) {
        int result = a - b;
        System.out.println("Difference: " + result);
    }

    void mul(int a, int b) {
        int result = a * b;
        System.out.println("Multiplication: " + result);
    }

    void div(int a, int b) {
        if (b != 0) {
            double result = (double) a / b;
            System.out.println("Division: " + result);
        } else {
            System.out.println("Division by zero is not allowed.");
        }
    }

    public static void main(String[] args) {
        Que11 obj = new Que11();

        int num1 = 20;
        int num2 = 5;

        obj.add(num1, num2);
        obj.diff(num1, num2);
        obj.mul(num1, num2);
        obj.div(num1, num2);
    }
}