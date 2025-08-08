package com.example.groceryapi.service;

import com.example.groceryapi.entity.GroceryItem;
import com.example.groceryapi.repository.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GroceryItemServiceTest {

    private final GroceryItemRepository repository = mock(GroceryItemRepository.class);
    private final GroceryItemService service = new GroceryItemServiceImpl(repository);

    @Test
    void testCreateItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Milk");
        item.setQuantity(2);
        item.setPrice(20.0);

        when(repository.save(any())).thenReturn(item);

        GroceryItem saved = service.createItem(item);
        assertEquals("Milk", saved.getName());
    }

    @Test
    void testGetItemById() {
        GroceryItem item = new GroceryItem();
        item.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(item));
        Optional<GroceryItem> found = service.getItemById(1L);
        assertTrue(found.isPresent());
    }
}
