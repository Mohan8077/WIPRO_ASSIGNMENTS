package Assainment1;

import java.io.*;
import java.util.*;

public class BatchMatesFileDemo {
    public static void main(String[] args) {
        String fileName = "batchmates.txt";
        List<String> batchMates = Arrays.asList(
            "Alice",
            "Bob",
            "Charlie",
            "David",
            "Eva",
            "Farhan",
            "Grace",
            "Helen"
        );

        // Write names to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String name : batchMates) {
                writer.write(name);
                writer.newLine();
            }
            System.out.println("Batchmates list successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Read and display names from file
        System.out.println("\nBatchmates from file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(count + ". " + line);
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
