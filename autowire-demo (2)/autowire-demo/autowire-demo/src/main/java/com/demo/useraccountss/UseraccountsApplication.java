package com.demo.useraccountss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UseraccountsApplication implements CommandLineRunner {

    @Autowired
    private AppProperties appProperties;

    public static void main(String[] args) {
        SpringApplication.run(UseraccountsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Loaded Properties:");
        System.out.println(appProperties);
    }
}
