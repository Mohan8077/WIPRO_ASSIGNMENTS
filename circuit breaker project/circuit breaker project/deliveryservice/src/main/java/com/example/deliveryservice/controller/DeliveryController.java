package com.example.deliveryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    @GetMapping("/delivery/status")
    public String getDeliveryStatus() {
        return "Delivery is on the way! Mr.Vishwas";
    }
}
