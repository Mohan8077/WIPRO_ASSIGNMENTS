package com.annotation.spring5;

import org.springframework.stereotype.Component;

@Component
public class Category {
    private int categoryId = 1;
    private String categoryName = "Default Category";

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

