package com.example.grocery.integration;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.repository.GroceryItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class GroceryItemIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GroceryItemRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        repository.deleteAll();
    }

    @Test
    void testCreateAndRetrieveItem() throws Exception {
        GroceryItem item = new GroceryItem(null, "Tomato", 3, 9.0);

        // Create
        MvcResult result = mockMvc.perform(post("/api/grocery")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Tomato"))
                .andReturn();

        String response = result.getResponse().getContentAsString();
        GroceryItem savedItem = objectMapper.readValue(response, GroceryItem.class);

        // Retrieve
        mockMvc.perform(get("/api/grocery/" + savedItem.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(3));
    }

    @Test
    void testGetAllItems() throws Exception {
        repository.save(new GroceryItem(null, "A", 1, 2.0));
        repository.save(new GroceryItem(null, "B", 2, 3.0));

        mockMvc.perform(get("/api/grocery"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }
}
