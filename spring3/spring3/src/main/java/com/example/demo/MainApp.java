package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("    AUTOWIRED ANNOTATION DEMO    ");
        System.out.println("==================================");
        System.out.println("Options:");
        System.out.println("1. Autowired");
        System.out.println("2. Autowired with Qualifier");
        System.out.print("Select option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume newline

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DormRoom selectedRoom = null;

        if (option == 1) {
            selectedRoom = context.getBean("room1", DormRoom.class); // default
        } else if (option == 2) {
            selectedRoom = context.getBean("room2", DormRoom.class); // qualified
        } else {
            System.out.println("Invalid option.");
            context.close();
            return;
        }

        Freshman freshman = context.getBean(Freshman.class);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        freshman.setName(name);

        // Manual injection override
        System.out.println("\n--- Student Info ---");
        System.out.println("Name: " + freshman.getName());
        System.out.println("Dorm Location: " + selectedRoom.getLocation());

        context.close();
        scanner.close();
    }
}
