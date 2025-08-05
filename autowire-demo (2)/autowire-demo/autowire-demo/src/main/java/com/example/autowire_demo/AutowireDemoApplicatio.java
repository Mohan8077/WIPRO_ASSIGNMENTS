package com.example.autowire_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AutowireDemoApplicatio implements CommandLineRunner {

    private final ClassKLM klm;

    public AutowireDemoApplicatio(ClassKLM klm) {
        this.klm = klm;
    }

    public static void main(String[] args) {
        SpringApplication.run(AutowireDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        klm.show();
    }
}
