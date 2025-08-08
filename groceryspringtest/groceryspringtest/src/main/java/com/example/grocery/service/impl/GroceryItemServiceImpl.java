package com.example.grocery.service.impl;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.repository.GroceryItemRepository;
import com.example.grocery.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    @Autowired
    private GroceryItemRepository repository;

    @Override
    public GroceryItem save(GroceryItem item) {
        return repository.save(item);
    }

    @Override
    public List<GroceryItem> findAll() {
        return repository.findAll();
    }

    @Override
    public GroceryItem findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Override
    public GroceryItem update(Long id, GroceryItem item) {
        GroceryItem existing = findById(id);
        existing.setName(item.getName());
        existing.setQuantity(item.getQuantity());
        existing.setPrice(item.getPrice());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
