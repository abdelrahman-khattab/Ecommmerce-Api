package com.restsoap.api.services.impl;

import java.util.List;

import com.restsoap.api.entities.Category;
import com.restsoap.api.persistance.impl.CategoryImpl;
import com.restsoap.api.services.CategoryServicesInt;

public class CategoryServicesImpl implements CategoryServicesInt {

    @Override
    public List<Category> getAllCategories() {
        // TODO Auto-generated method stub
        return new CategoryImpl().getAllCategories();
    }

    @Override
    public Category getCategory(int id) {
        // TODO Auto-generated method stub
        return new CategoryImpl().getCategory(id);
    }

    @Override
    public Category updateCategory(Category category) {
        // TODO Auto-generated method stub
        return new CategoryImpl().updateCategory(category);
    }

    @Override
    public void deleteCategory(Category category) {
        // TODO Auto-generated method stub
        new CategoryImpl().deleteCategory(category);
    }

    @Override
    public void addCategory(Category category) {
        // TODO Auto-generated method stub
        new CategoryImpl().addCategory(category);
    }

}
