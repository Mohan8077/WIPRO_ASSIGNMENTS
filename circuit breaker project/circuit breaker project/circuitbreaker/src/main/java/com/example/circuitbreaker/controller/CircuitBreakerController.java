package com.example.circuitbreaker.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@RestController
public class CircuitBreakerController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String CB_INSTANCE_NAME = "deliveryService";

    @GetMapping("/order/status")
    @CircuitBreaker(name = CB_INSTANCE_NAME, fallbackMethod = "deliveryFallback")
    public String getOrderStatus() {
        String url = "http://localhost:8081/delivery/status";
        return restTemplate.getForObject(url, String.class);
    }

    public String deliveryFallback(Exception e) {
        return "❌ Delivery Service is currently unavailable. Please try again later.";
    }

   
  
    }

