package com.annotation.spring5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Item {
    private int id;
    private String name;
    private double price;

    @Autowired
    private Category category;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {
        System.out.println("\n--- Item Details ---");
        System.out.println("ID       : " + id);
        System.out.println("Name     : " + name);
        System.out.println("Price    : " + price);

        if (category != null) {
            System.out.println("Category ID   : " + category.getCategoryId());
            System.out.println("Category Name : " + category.getCategoryName());
        } else {
            System.out.println("No category assigned.");
        }
    }

    public Category getCategory() {
        return category;
    }
}

