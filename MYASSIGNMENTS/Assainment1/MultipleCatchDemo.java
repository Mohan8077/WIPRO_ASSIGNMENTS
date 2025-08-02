package Assainment1;

import java.util.ArrayList;

public class MultipleCatchDemo {
    public static void main(String[] args) {

        // 1. NegativeArraySizeException
        try {
            System.out.println("=== Test 1: NegativeArraySizeException ===");
            int[] arr = new int[-5];
        } catch (NegativeArraySizeException e) {
            System.out.println("Caught NegativeArraySizeException");
            e.printStackTrace();
        }

        // 2. ArrayIndexOutOfBoundsException
        try {
            System.out.println("\n=== Test 2: ArrayIndexOutOfBoundsException ===");
            int[] arr = new int[3];
            int x = arr[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }

        // 3. StringIndexOutOfBoundsException
        try {
            System.out.println("\n=== Test 3: StringIndexOutOfBoundsException ===");
            String str = "Hello";
            char ch = str.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
            e.printStackTrace();
        }

        // 4. IndexOutOfBoundsException (with ArrayList)
        try {
            System.out.println("\n=== Test 4: IndexOutOfBoundsException ===");
            ArrayList<Integer> list = new ArrayList<>();
            list.add(10);
            int value = list.get(3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException");
            e.printStackTrace();
        }

        // 5. NullPointerException
        try {
            System.out.println("\n=== Test 5: NullPointerException ===");
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
            e.printStackTrace();
        }

        // 6. ArithmeticException
        try {
            System.out.println("\n=== Test 6: ArithmeticException ===");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
            e.printStackTrace();
        }

        System.out.println("\nProgram completed.");
    }
}
