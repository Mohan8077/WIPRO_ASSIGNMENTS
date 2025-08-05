package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo")
public class AppConfig {

    @Bean(name = "room1")
    public DormRoom room1() {
        return new DormRoom(101, "A");
    }

    @Bean(name = "room2")
    public DormRoom room2() {
        return new DormRoom(202, "B");
    }
}
