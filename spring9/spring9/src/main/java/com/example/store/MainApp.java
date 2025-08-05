package com.example.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for purchaseId and purchaseDate (optional since it's in XML)
        System.out.println("Spring will auto-wire the product using constructor.");
        System.out.println("Press ENTER to proceed...");
        scanner.nextLine();

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Purchase purchase = (Purchase) context.getBean("purchase");

        purchase.displayPurchase();
    }
}
