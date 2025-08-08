package com.consumer.restaurantconsumer.controller;

import com.consumer.restaurantconsumer.client.*;
import com.consumer.restaurantconsumer.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final RestaurantClient restaurantClient;

    @Autowired
    public ConsumerController(RestaurantClient restaurantClient) {
        this.restaurantClient = restaurantClient;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurantsFromProducer() {
        // Call the producer service via the Feign client
        return restaurantClient.getRestaurants();
    }
}
