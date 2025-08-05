package com.example.main;

import com.example.model.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Account acc = (Account) context.getBean("account");
        System.out.println(acc);
    }
}
