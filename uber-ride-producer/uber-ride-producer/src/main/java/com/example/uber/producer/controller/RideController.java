package com.example.uber.producer.controller;

import com.example.uber.producer.dto.RideDTO;
import com.example.uber.producer.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final KafkaProducerService producerService;

    public RideController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<String> createRide(@RequestBody RideDTO ride) {
        producerService.sendRide(ride, "CREATE");
        return ResponseEntity.ok("CREATE message sent to Kafka");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRide(@PathVariable Long id, @RequestBody RideDTO ride) {
        ride.setId(id);
        producerService.sendRide(ride, "UPDATE");
        return ResponseEntity.ok("UPDATE message sent to Kafka");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelRide(@PathVariable Long id) {
        producerService.sendDelete(id);
        return ResponseEntity.ok("DELETE message sent to Kafka");
    }

    // Optional mock GET (consumer owns DB)
    @GetMapping("/{id}")
    public ResponseEntity<RideDTO> getMockRide(@PathVariable Long id) {
        RideDTO mock = new RideDTO();
        mock.setId(id);
        mock.setDriverName("mock driver");
        mock.setPassengerName("mock passenger");
        mock.setPickupLocation("mock pickup");
        mock.setDropLocation("mock drop");
        mock.setFare(0.0);
        return ResponseEntity.ok(mock);
    }
}
