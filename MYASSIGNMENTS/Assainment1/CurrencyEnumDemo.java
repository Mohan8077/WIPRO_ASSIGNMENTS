package Assainment1;
public class CurrencyEnumDemo {

    // Step 1: Define the enum
    enum Currency {
        ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
    }

    public static void main(String[] args) {

        // Step 2: Loop through values() and print each currency
        System.out.println("Paper Currency Types:");
        for (Currency c : Currency.values()) {
            System.out.println(c);
        }

        System.out.println("\nCurrency Descriptions:");

        // Step 3: Switch statement for descriptions
        for (Currency c : Currency.values()) {
            switch (c) {
                case ONE:
                    System.out.println("ONE: Smallest paper currency denomination.");
                    break;
                case FIVE:
                    System.out.println("FIVE: Commonly used low-value note.");
                    break;
                case TEN:
                    System.out.println("TEN: Often used for small transactions.");
                    break;
                case TWENTY:
                    System.out.println("TWENTY: Medium denomination for everyday use.");
                    break;
                case FIFTY:
                    System.out.println("FIFTY: Larger note used for significant purchases.");
                    break;
                case HUNDRED:
                    System.out.println("HUNDRED: High-value note, often used in banks.");
                    break;
                default:
                    System.out.println("Unknown currency.");
            }
        }
    }
}