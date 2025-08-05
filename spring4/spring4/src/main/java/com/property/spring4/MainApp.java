package com.property.spring4;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Account account = (Account) context.getBean("accountBean");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to override details? (yes/no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.print("Enter account number: ");
            account.setNumber(scanner.nextInt());
            scanner.nextLine(); // consume newline

            System.out.print("Enter account holder name: ");
            account.setHolder(scanner.nextLine());

            System.out.print("Enter account balance: ");
            account.setBalance(scanner.nextDouble());
            scanner.nextLine();

            System.out.print("Enter account type: ");
            account.setType(scanner.nextLine());
        }

        System.out.println("\n--- Account Details ---");
        account.displayDetails();

        scanner.close();
    }
}
