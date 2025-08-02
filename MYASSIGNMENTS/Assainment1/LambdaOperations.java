package Assainment1;

public class LambdaOperations {

    // Functional Interface
    interface PerformOperation {
        boolean check(int a);
    }

    // Lambda to check if number is odd
    public static PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    // Lambda to check if number is prime
    public static PerformOperation isPrime() {
        return (int a) -> {
            if (a <= 1) return false;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    // Lambda to check if number is a palindrome
    public static PerformOperation isPalindrome() {
        return (int a) -> {
            String str = Integer.toString(a);
            return str.equals(new StringBuilder(str).reverse().toString());
        };
    }

    // Method to execute the operation
    public static void testOperation(PerformOperation op, int number, String operationName) {
        System.out.println(operationName + " on " + number + ": " + op.check(number));
    }

    // Main method to test all
    public static void main(String[] args) {
        int testNumber1 = 5;
        int testNumber2 = 7;
        int testNumber3 = 121;

        testOperation(isOdd(), testNumber1, "IsOdd");
        testOperation(isPrime(), testNumber2, "IsPrime");
        testOperation(isPalindrome(), testNumber3, "IsPalindrome");
    }
}