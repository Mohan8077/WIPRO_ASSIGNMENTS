package com.example.uber.consumer.controller;

import com.example.uber.consumer.entity.Ride;
import com.example.uber.consumer.repository.RideRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideRepository repository;

    public RideController(RideRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Ride>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ride> getById(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
