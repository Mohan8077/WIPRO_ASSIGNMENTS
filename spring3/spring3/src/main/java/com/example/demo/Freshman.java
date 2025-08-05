package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Freshman {
    private String name;

    @Autowired
    @Qualifier("room1") // Can be changed dynamically
    private DormRoom room;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room.getLocation();
    }
}
