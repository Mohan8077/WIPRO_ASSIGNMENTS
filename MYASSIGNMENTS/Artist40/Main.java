package Artist40;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CD> cdList = new ArrayList<>();
        cdList.add(new CD("Divide", "Ed Sheeran"));
        cdList.add(new CD("Thriller", "Michael Jackson"));
        cdList.add(new CD("25", "Adele"));
        cdList.add(new CD("Lover", "Taylor Swift"));

        System.out.println("Before Sorting:");
        for (CD cd : cdList) {
            System.out.println(cd);
        }

        Collections.sort(cdList); // Sort using Comparable

        System.out.println("\nAfter Sorting by Singer (Ascending):");
        for (CD cd : cdList) {
            System.out.println(cd);
        }
    }
}
