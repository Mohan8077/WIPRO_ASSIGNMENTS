package com.example.main;

import com.example.dao.ItemDAO;
import com.example.model.Item;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ItemDAO dao = new ItemDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Hibernate Item CRUD");
            System.out.println("-------------------------------");
            System.out.println("1. Add");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Get by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    Item newItem = new Item();
                    newItem.setName(name);
                    newItem.setPrice(price);
                    dao.addItem(newItem);
                    System.out.println("Item added.");
                    break;

                case 2:
                    dao.getAllItems().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    Item updateItem = dao.getItemById(updateId);
                    if (updateItem != null) {
                        sc.nextLine();
                        System.out.print("Enter new name: ");
                        updateItem.setName(sc.nextLine());
                        System.out.print("Enter new price: ");
                        updateItem.setPrice(sc.nextDouble());
                        dao.updateItem(updateItem);
                        System.out.println("Item updated.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    dao.deleteItem(sc.nextInt());
                    System.out.println("Item deleted.");
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    Item item = dao.getItemById(sc.nextInt());
                    if (item != null) {
                        System.out.println(item);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
