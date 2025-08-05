package com.example.store;

public class Purchase {
    private int purchaseId;
    private String purchaseDate;
    private Product product;

    // Constructor-based injection
    public Purchase(int purchaseId, String purchaseDate, Product product) {
        this.purchaseId = purchaseId;
        this.purchaseDate = purchaseDate;
        this.product = product;
    }

    public void displayPurchase() {
        System.out.println("Purchase ID: " + purchaseId);
        System.out.println("Date: " + purchaseDate);
        System.out.println("Product Details:");
        product.displayProduct();
    }
}
