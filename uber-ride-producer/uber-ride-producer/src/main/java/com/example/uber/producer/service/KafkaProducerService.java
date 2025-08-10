package com.example.uber.producer.service;

import com.example.uber.producer.dto.RideDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${app.kafka.topic}")
    private String topic;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRide(RideDTO ride, String operation) {
        try {
            ObjectNode node = objectMapper.createObjectNode();
            node.put("operation", operation);
            if (ride.getId() != null) node.put("id", ride.getId());
            node.put("driverName", ride.getDriverName());
            node.put("passengerName", ride.getPassengerName());
            node.put("pickupLocation", ride.getPickupLocation());
            node.put("dropLocation", ride.getDropLocation());
            node.put("fare", ride.getFare() == null ? 0.0 : ride.getFare());
            String json = objectMapper.writeValueAsString(node);
            kafkaTemplate.send(topic, json);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send ride message", e);
        }
    }

    // helper for delete-only messages
    public void sendDelete(Long id) {
        try {
            ObjectNode node = objectMapper.createObjectNode();
            node.put("operation", "DELETE");
            node.put("id", id);
            kafkaTemplate.send(topic, objectMapper.writeValueAsString(node));
        } catch (Exception e) {
            throw new RuntimeException("Failed to send delete message", e);
        }
    }
}
