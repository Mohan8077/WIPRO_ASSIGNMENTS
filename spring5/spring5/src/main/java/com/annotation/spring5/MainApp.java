package com.annotation.spring5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Item item = context.getBean(Item.class);
        Category category = item.getCategory();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Item ID: ");
        item.setId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Item Name: ");
        item.setName(sc.nextLine());

        System.out.print("Enter Item Price: ");
        item.setPrice(sc.nextDouble());
        sc.nextLine();

        System.out.print("Enter Category ID: ");
        category.setCategoryId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Category Name: ");
        category.setCategoryName(sc.nextLine());

        item.display();
        sc.close();
    }
}

