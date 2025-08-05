package com.example.autowire_demo;

import org.springframework.stereotype.Component;

@Component("classXYZ")
public class ClassXYZ implements InterfacePQR {

    @Override
    public void display() {
        System.out.println("Hi... I am ClassXYZ");
    }
}
