package com.example.groceryapi.service;

import com.example.groceryapi.entity.GroceryItem;
import com.example.groceryapi.repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    private final GroceryItemRepository repository;

    public GroceryItemServiceImpl(GroceryItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public GroceryItem createItem(GroceryItem item) {
        return repository.save(item);
    }

    @Override
    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    @Override
    public Optional<GroceryItem> getItemById(Long id) {
        return repository.findById(id);
    }

    @Override
    public GroceryItem updateItem(Long id, GroceryItem item) {
        GroceryItem existing = repository.findById(id).orElseThrow();
        existing.setName(item.getName());
        existing.setQuantity(item.getQuantity());
        existing.setPrice(item.getPrice());
        return repository.save(existing);
    }

    @Override
    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}
