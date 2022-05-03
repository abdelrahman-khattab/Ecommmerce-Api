package com.restsoap.api.persistance;

import java.util.List;

import com.restsoap.api.entities.Category;

public interface CategoryInt {
    List<Category> getAllCategories();

    Category getCategory(int id);

    Category updateCategory(Category category);

    void deleteCategory(Category category);

    void addCategory(Category category);
}
