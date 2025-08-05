package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectController {

    @GetMapping("/example/test")
    public String redirectToTest2() {
        return "redirect:/example/test2"; // ❌ This won't work in RestController
    }

    @GetMapping("/example/test2")
    public String test2() {
        return "You have been redirected to /example/test2";
    }
}
