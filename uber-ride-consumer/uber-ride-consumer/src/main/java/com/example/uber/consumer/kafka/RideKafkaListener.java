package com.example.uber.consumer.kafka;

import com.example.uber.consumer.entity.Ride;
import com.example.uber.consumer.repository.RideRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RideKafkaListener {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RideRepository rideRepository;

    public RideKafkaListener(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        try {
            JsonNode node = objectMapper.readTree(message);
            String operation = node.get("operation").asText();

            Long id = node.has("id") && !node.get("id").isNull() ? node.get("id").asLong() : null;

            switch (operation) {
                case "CREATE": {
                    Ride r = new Ride();
                    r.setId(id);
                    r.setDriverName(node.has("driverName") ? node.get("driverName").asText() : null);
                    r.setPassengerName(node.has("passengerName") ? node.get("passengerName").asText() : null);
                    r.setPickupLocation(node.has("pickupLocation") ? node.get("pickupLocation").asText() : null);
                    r.setDropLocation(node.has("dropLocation") ? node.get("dropLocation").asText() : null);
                    r.setFare(node.has("fare") ? node.get("fare").asDouble() : 0.0);
                    rideRepository.save(r);
                    break;
                }
                case "UPDATE": {
                    if (id != null && rideRepository.existsById(id)) {
                        Ride existing = rideRepository.findById(id).get();
                        if (node.has("driverName")) existing.setDriverName(node.get("driverName").asText());
                        if (node.has("passengerName")) existing.setPassengerName(node.get("passengerName").asText());
                        if (node.has("pickupLocation")) existing.setPickupLocation(node.get("pickupLocation").asText());
                        if (node.has("dropLocation")) existing.setDropLocation(node.get("dropLocation").asText());
                        if (node.has("fare")) existing.setFare(node.get("fare").asDouble());
                        rideRepository.save(existing);
                    } else {
                        // if not exist, create new with provided id
                        Ride r2 = new Ride();
                        r2.setId(id);
                        r2.setDriverName(node.has("driverName") ? node.get("driverName").asText() : null);
                        r2.setPassengerName(node.has("passengerName") ? node.get("passengerName").asText() : null);
                        r2.setPickupLocation(node.has("pickupLocation") ? node.get("pickupLocation").asText() : null);
                        r2.setDropLocation(node.has("dropLocation") ? node.get("dropLocation").asText() : null);
                        r2.setFare(node.has("fare") ? node.get("fare").asDouble() : 0.0);
                        rideRepository.save(r2);
                    }
                    break;
                }
                case "DELETE": {
                    if (id != null) {
                        rideRepository.deleteById(id);
                    }
                    break;
                }
                default:
                    // unknown operation
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
