package Assainment1;
import java.util.*;

public class RemoveDuplicatesSumEven {
    public static void main(String[] args) {
        int[] input = {2, 3, 54, 1, 6, 7, 7};

        // Use a Set to remove duplicates
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : input) {
            uniqueNumbers.add(num);
        }

        // Calculate sum of even numbers
        int evenSum = 0;
        for (int num : uniqueNumbers) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }

        // Print the result
        System.out.println("Sum of even numbers (after removing duplicates): " + evenSum);
    }
}