package com.example.grocery.service;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.repository.GroceryItemRepository;
import com.example.grocery.service.impl.GroceryItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroceryItemServiceTest {

    @InjectMocks
    private GroceryItemServiceImpl service;

    @Mock
    private GroceryItemRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        GroceryItem item = new GroceryItem();
        item.setName("Apple");
        item.setQuantity(5);
        item.setPrice(10.0);

        when(repository.save(item)).thenReturn(item);

        GroceryItem saved = service.save(item);
        assertEquals("Apple", saved.getName());
    }

    @Test
    void testFindAll() {
        List<GroceryItem> list = Arrays.asList(
                new GroceryItem(1L, "Apple", 5, 10.0),
                new GroceryItem(2L, "Banana", 3, 5.0)
        );
        when(repository.findAll()).thenReturn(list);

        List<GroceryItem> result = service.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void testFindById() {
        GroceryItem item = new GroceryItem(1L, "Apple", 5, 10.0);
        when(repository.findById(1L)).thenReturn(Optional.of(item));

        GroceryItem found = service.findById(1L);
        assertEquals("Apple", found.getName());
    }

    @Test
    void testUpdate() {
        GroceryItem existing = new GroceryItem(1L, "Apple", 5, 10.0);
        GroceryItem updated = new GroceryItem(null, "Orange", 10, 20.0);

        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any())).thenReturn(updated);

        GroceryItem result = service.update(1L, updated);
        assertEquals("Orange", result.getName());
        assertEquals(10, result.getQuantity());
    }

    @Test
    void testDelete() {
        doNothing().when(repository).deleteById(1L);
        service.delete(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}
