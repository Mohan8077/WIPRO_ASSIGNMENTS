package com.consumer.restaurantconsumer.client;

import com.consumer.restaurantconsumer.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// The name "restaurant-producer" must match the spring.application.name of the producer service
@FeignClient(name = "restaurant-producer")
public interface RestaurantClient {

    // This defines a GET request to the "/restaurants" endpoint of the producer
    @GetMapping("/restaurants")
    List<Restaurant> getRestaurants();
}
