package house;

import java.util.Arrays;

public class Kitchen {
    public void showAppliances() {
        String[] appliances = { "Refrigerator", "Oven", "Microwave", "Toaster", "Dishwasher" };

        // Print original array
        System.out.println("Original appliances:");
        for (String appliance : appliances) {
            System.out.println(appliance);
        }

        // Copy array to another array
        String[] copiedAppliances = Arrays.copyOf(appliances, appliances.length);

        // Print copied array
        System.out.println("\nCopied appliances:");
        for (String appliance : copiedAppliances) {
            System.out.println(appliance);
        }
    }
}
