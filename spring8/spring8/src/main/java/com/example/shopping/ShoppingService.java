package com.example.shopping;

public class ShoppingService {
    private String item;
    private int quantity;

    public void addToCart(String item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void placeOrder() {
        System.out.println("Welcome to Fresh Mart - Category: Groceries");
        System.out.println("Purchased " + quantity + " unit(s) of '" + item + "'. Thank you for shopping!");
    }
}
