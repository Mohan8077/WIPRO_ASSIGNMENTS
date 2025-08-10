package com.example.uber.consumer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rides")
public class Ride {

    @Id
    @Column(name = "id")
    private Long id; // provided by producer

    @Column(name = "driver_name", length = 100)
    private String driverName;

    @Column(name = "passenger_name", length = 100)
    private String passengerName;

    @Column(name = "pickup_location", length = 255)
    private String pickupLocation;

    @Column(name = "drop_location", length = 255)
    private String dropLocation;

    @Column(name = "fare")
    private Double fare;

    public Ride(){}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }
    public String getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }
    public String getDropLocation() { return dropLocation; }
    public void setDropLocation(String dropLocation) { this.dropLocation = dropLocation; }
    public Double getFare() { return fare; }
    public void setFare(Double fare) { this.fare = fare; }
}
