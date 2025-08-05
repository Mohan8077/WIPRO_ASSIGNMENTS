package com.example.restaurantapi.controller;

import com.example.restaurantapi.entity.Food;
import com.example.restaurantapi.entity.Restaurant;
import com.example.restaurantapi.exception.ResourceNotFoundException;
import com.example.restaurantapi.repository.FoodRepository;
import com.example.restaurantapi.repository.RestaurantRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepo;

    @Autowired
    private FoodRepository foodRepo;

    // POST /api/restaurants
    @PostMapping
    public Restaurant createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    // GET /api/restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    // GET /api/restaurants/{id}
    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + id));
    }

    // DELETE /api/restaurants/{id}
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        Restaurant res = restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + id));
        restaurantRepo.delete(res);
    }

    // POST /api/restaurants/{id}/foc
    @PostMapping("/{id}/foc")
    public Food addFoodToRestaurant(@PathVariable Long id, @Valid @RequestBody Food food) {
        Restaurant res = restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + id));
        food.setRestaurant(res);
        return foodRepo.save(food);
    }

    // DELETE /api/restaurants/foods/{foodId}
    @DeleteMapping("/foods/{foodId}")
    public void deleteFood(@PathVariable Long foodId) {
        Food food = foodRepo.findById(foodId)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id " + foodId));
        foodRepo.delete(food);
    }
}
