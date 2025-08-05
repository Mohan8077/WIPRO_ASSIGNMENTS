package com.example.autowire_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClassKLM {

    @Autowired
    @Qualifier("classABC")  // You can change to "classXYZ" to inject the other
    private InterfacePQR pqr;

    public void show() {
        pqr.display();
    }
}

