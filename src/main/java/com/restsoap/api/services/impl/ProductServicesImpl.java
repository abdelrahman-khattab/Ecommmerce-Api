package com.restsoap.api.services.impl;

import java.util.List;

import com.restsoap.api.entities.Product;
import com.restsoap.api.persistance.impl.ProductImpl;
import com.restsoap.api.services.ProductServicesInt;

public class ProductServicesImpl implements ProductServicesInt{

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        return new ProductImpl().getAllProducts();
    }

    @Override
    public Product getProduct(int id) {
        // TODO Auto-generated method stub
        return new ProductImpl().getProduct(id);
    }

    @Override
    public Product updateProduct(Product product) {
        // TODO Auto-generated method stub
        return new ProductImpl().updateProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        // TODO Auto-generated method stub
        new ProductImpl().deleteProduct(product);
    }

    @Override
    public void addProduct(Product product) {
        // TODO Auto-generated method stub
        new ProductImpl().addProduct(product);
        
    }
    
}
