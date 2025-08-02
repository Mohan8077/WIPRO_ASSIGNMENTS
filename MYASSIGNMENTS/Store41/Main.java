package Store41;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<BookStore> books = new ArrayList<>();
        books.add(new BookStore(103, "Java Basics"));
        books.add(new BookStore(101, "C Programming"));
        books.add(new BookStore(105, "Python Essentials"));
        books.add(new BookStore(102, "C Programming")); // Same name, different ID

        System.out.println("Original List:");
        books.forEach(System.out::println);

        // Sort by book name
        books.sort(new BookNameComparator());

        System.out.println("\nSorted by Book Name:");
        books.forEach(System.out::println);

        // Sort by book ID
        books.sort(new BookIdComparator());

        System.out.println("\nSorted by Book ID:");
        books.forEach(System.out::println);
    }
}
