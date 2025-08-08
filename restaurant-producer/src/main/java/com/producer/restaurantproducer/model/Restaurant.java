package com.producer.restaurantproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Restaurant {
    private long id;
    private String name;
    private String location;

    // <-- THIS IS THE FIX: Manually define the constructor.
    public Restaurant(long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    // You would also need to manually add getters and setters...
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

