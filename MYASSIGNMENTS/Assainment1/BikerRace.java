package Assainment1;

import java.util.Scanner;

public class BikerRace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] speeds = new double[5];
        double sum = 0;

        // Taking speed input from the user
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter speed of biker " + (i + 1) + ": ");
            speeds[i] = sc.nextDouble();
            sum += speeds[i];
        }

        double average = sum / 5.0;

        System.out.println("\nAverage speed: " + average);
        System.out.println("Qualifying racers (speed > average):");

        // Displaying qualifying bikers
        for (int i = 0; i < 5; i++) {
            if (speeds[i] > average) {
                System.out.println("Biker " + (i + 1) + ": " + speeds[i]);
            }
        }

        sc.close();
    }
}