package com.example.redirectdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedirectController {

    @GetMapping("/example/test")
    public String redirect() {
        return "redirect:/example/test2";
    }

    @GetMapping("/example/test2")
    @ResponseBody
    public String finalEndpoint() {
        return "Test 2 Page reached!";
    }
}
