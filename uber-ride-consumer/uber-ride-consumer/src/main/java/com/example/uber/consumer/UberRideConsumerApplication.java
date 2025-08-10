package com.example.uber.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class UberRideConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UberRideConsumerApplication.class, args);
    }
}
//http://localhost:8081/rides(first run this)