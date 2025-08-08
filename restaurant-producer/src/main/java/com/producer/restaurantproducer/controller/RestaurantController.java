package com.producer.restaurantproducer.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producer.restaurantproducer.model.Restaurant;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @GetMapping
    public List<Restaurant> getRestaurants() {
        // Return a sample list of restaurants
        return Arrays.asList(
            new Restaurant(1L, "Paradise", "Hyderabad"),
            new Restaurant(2L, "Ulavacharu", "Vijayawada"),
            new Restaurant(3L, "Dakshin", "Chennai")
        );
    }
}
