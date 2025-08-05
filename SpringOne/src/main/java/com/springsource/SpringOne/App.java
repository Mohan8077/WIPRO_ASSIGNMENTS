package com.springsource.SpringOne;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:datafile.properties")
@ComponentScan("com.springsource.SpringOne")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        MyBean loader = context.getBean(MyBean.class);

        System.out.println("URL      : " + loader.getUrl());
        System.out.println("Username : " + loader.getUsername());
        System.out.println("Password : " + loader.getPassword());

        context.close();
    }
}
