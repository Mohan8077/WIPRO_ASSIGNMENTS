package Assainment1;

public class Que10 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the number of eggs as a command line argument.");
            return;
        }

        int eggs = Integer.parseInt(args[0]);

        int gross = eggs / 144;
        eggs = eggs % 144;

        int dozen = eggs / 12;
        int leftover = eggs % 12;

        System.out.println("Your number of eggs is: " + gross + " gross, " + dozen + " dozen, and " + leftover);
    }
}