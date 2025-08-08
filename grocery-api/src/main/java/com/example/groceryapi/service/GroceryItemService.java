package com.example.groceryapi.service;

import com.example.groceryapi.entity.GroceryItem;

import java.util.List;
import java.util.Optional;

public interface GroceryItemService {
    GroceryItem createItem(GroceryItem item);
    List<GroceryItem> getAllItems();
    Optional<GroceryItem> getItemById(Long id);
    GroceryItem updateItem(Long id, GroceryItem item);
    void deleteItem(Long id);
}
