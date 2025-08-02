package QNO51;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamApiExample {

    public static void main(String[] args) {

        // Creating Sample Products
        Product book1 = new Product(1L, "Java Programming", "Books", 120.0);
        Product book2 = new Product(2L, "Advanced Java", "Books", 150.0);
        Product toy1 = new Product(3L, "Teddy Bear", "Toys", 25.0);
        Product toy2 = new Product(4L, "Remote Car", "Toys", 80.0);
        Product babyToy = new Product(5L, "Baby Rattle", "Baby", 10.0);
        
        // Creating Sample Customers
        Customer customer1 = new Customer(1L, "Alice", 1);  // Tier 1
        Customer customer2 = new Customer(2L, "Bob", 2);    // Tier 2
        Customer customer3 = new Customer(3L, "Charlie", 1); // Tier 1

        // Creating Sample Orders
        List<Product> products1 = Arrays.asList(book1, toy1);
        List<Product> products2 = Arrays.asList(book2, toy2);
        List<Product> products3 = Arrays.asList(babyToy, toy1);

        Order order1 = new Order(1L, "Delivered", LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 18), products1, customer1);
        Order order2 = new Order(2L, "Pending", LocalDate.of(2021, 3, 10), LocalDate.of(2021, 3, 12), products2, customer2);
        Order order3 = new Order(3L, "Delivered", LocalDate.of(2021, 4, 20), LocalDate.of(2021, 4, 22), products3, customer3);

        List<Product> productList = Arrays.asList(book1, book2, toy1, toy2, babyToy);
        List<Order> orderList = Arrays.asList(order1, order2, order3);

        // Task 1: Obtain a list of products in 'Books' category with price > 100
        List<Product> booksOver100 = productList.stream()
                .filter(p -> p.getCategory().equals("Books") && p.getPrice() > 100)
                .collect(Collectors.toList());
        System.out.println("Books with price > 100:");
        booksOver100.forEach(System.out::println);

        // Task 2: Obtain a list of orders with products from 'Baby' category
        List<Order> ordersWithBabyProducts = orderList.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equals("Baby")))
                .collect(Collectors.toList());
        System.out.println("\nOrders with 'Baby' products:");
        ordersWithBabyProducts.forEach(System.out::println);

        // Task 3: Apply 10% discount to products in 'Toys' category
        List<Product> discountedToys = productList.stream()
                .filter(p -> p.getCategory().equals("Toys"))
                .map(p -> {
                    p.setPrice(p.getPrice() * 0.9); // Apply 10% discount
                    return p;
                })
                .collect(Collectors.toList());
        System.out.println("\nDiscounted 'Toys' products (10% off):");
        discountedToys.forEach(System.out::println);

        // Task 4: Obtain a list of products ordered by tier 2 customers between 01-Feb-2021 and 01-Apr-2021
        List<Product> tier2OrderedProducts = orderList.stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> !order.getOrderDate().isBefore(LocalDate.of(2021, 2, 1)) && !order.getOrderDate().isAfter(LocalDate.of(2021, 4, 1)))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());
        System.out.println("\nProducts ordered by Tier 2 customers between 01-Feb-2021 and 01-Apr-2021:");
        tier2OrderedProducts.forEach(System.out::println);

        // Task 5: Get the cheapest product in 'Books' category
        Optional<Product> cheapestBook = productList.stream()
                .filter(p -> p.getCategory().equals("Books"))
                .min(Comparator.comparingDouble(Product::getPrice));
        System.out.println("\nCheapest product in 'Books' category:");
        cheapestBook.ifPresent(System.out::println);

        // Task 6: Get the 3 most recent orders (sorted by order date descending)
        List<Order> recentOrders = orderList.stream()
                .sorted((o1, o2) -> o2.getOrderDate().compareTo(o1.getOrderDate())) // Descending order
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("\nMost recent orders:");
        recentOrders.forEach(System.out::println);

        // Task 7: Calculate total lump sum of all orders placed in February 2021
        double totalLumpSum = orderList.stream()
                .filter(order -> !order.getOrderDate().isBefore(LocalDate.of(2021, 2, 1)) && !order.getOrderDate().isAfter(LocalDate.of(2021, 2, 28)))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("\nTotal lump sum of orders placed in February 2021: ₹" + totalLumpSum);

        // Task 8: Get statistics (sum, average, max, min, count) for all products in 'Books' category
        DoubleSummaryStatistics stats = productList.stream()
                .filter(p -> p.getCategory().equals("Books"))
                .collect(Collectors.summarizingDouble(Product::getPrice));
        System.out.println("\nStatistics for 'Books' products:");
        System.out.println("Sum: ₹" + stats.getSum());
        System.out.println("Average: ₹" + stats.getAverage());
        System.out.println("Max: ₹" + stats.getMax());
        System.out.println("Min: ₹" + stats.getMin());
        System.out.println("Count: " + stats.getCount());

        // Task 9: Find the most expensive product in the 'Books' category
        Optional<Product> mostExpensiveBook = productList.stream()
                .filter(p -> p.getCategory().equals("Books"))
                .collect(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)));
        System.out.println("\nMost expensive product in 'Books' category:");
        mostExpensiveBook.ifPresent(System.out::println);
    }
}
