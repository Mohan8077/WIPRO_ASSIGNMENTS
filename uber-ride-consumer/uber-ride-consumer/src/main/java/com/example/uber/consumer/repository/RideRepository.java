package com.example.uber.consumer.repository;

import com.example.uber.consumer.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
