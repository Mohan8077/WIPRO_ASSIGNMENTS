package com.example.userapi.controller;

import com.example.userapi.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        return "User received: " + user.getFirstName() + " " + user.getLastName() + ", age: " + user.getAge();
    }
}
