package com.consumer.restaurantconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.consumer.restaurantconsumer")
@EnableDiscoveryClient
@EnableFeignClients
public class RestaurantConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantConsumerApplication.class, args);
    }

}

//http://localhost:8082/consumer/restaurants