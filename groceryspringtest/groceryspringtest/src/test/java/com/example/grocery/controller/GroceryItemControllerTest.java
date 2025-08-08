package com.example.grocery.controller;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.service.GroceryItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GroceryItemController.class)
class GroceryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddItem() throws Exception {
        GroceryItem item = new GroceryItem(null, "Mango", 2, 15.0);
        GroceryItem savedItem = new GroceryItem(1L, "Mango", 2, 15.0);

        Mockito.when(service.save(Mockito.any())).thenReturn(savedItem);

        mockMvc.perform(post("/api/grocery")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mango"));
    }

    @Test
    void testGetAllItems() throws Exception {
        List<GroceryItem> list = Arrays.asList(
                new GroceryItem(1L, "A", 2, 10.0),
                new GroceryItem(2L, "B", 1, 5.0)
        );

        Mockito.when(service.findAll()).thenReturn(list);

        mockMvc.perform(get("/api/grocery"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testGetItem() throws Exception {
        GroceryItem item = new GroceryItem(1L, "Apple", 5, 10.0);
        Mockito.when(service.findById(1L)).thenReturn(item);

        mockMvc.perform(get("/api/grocery/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Apple"));
    }

    @Test
    void testDeleteItem() throws Exception {
        Mockito.doNothing().when(service).delete(1L);

        mockMvc.perform(delete("/api/grocery/1"))
                .andExpect(status().isOk());
    }
}
