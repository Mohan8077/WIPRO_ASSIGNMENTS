package com.example.groceryapi.integration;

import com.example.grocery_api.GroceryApiApplication;
import com.example.groceryapi.entity.GroceryItem;
import com.example.groceryapi.repository.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = GroceryApiApplication.class)
public class GroceryItemIntegrationTest {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Test
    public void testSaveAndFindItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Sugar");
        item.setQuantity(3);
        item.setPrice(45.0);

        GroceryItem savedItem = groceryItemRepository.save(item);
        Optional<GroceryItem> foundItem = groceryItemRepository.findById(savedItem.getId());

        assertTrue(foundItem.isPresent());
        assertEquals("Sugar", foundItem.get().getName());
    }
}
