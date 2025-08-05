package com.example.shopping;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ShoppingService shoppingService = (ShoppingService) context.getBean("shoppingService");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String item = scanner.nextLine();
        shoppingService.addToCart(item);

        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();
        shoppingService.setQuantity(qty);

        shoppingService.placeOrder();
    }
}
