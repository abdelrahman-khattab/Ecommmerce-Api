package com.restsoap.api.persistance;

import java.util.List;

import com.restsoap.api.entities.Product;

public interface ProductInt {
    List<Product> getAllProducts();

    Product getProduct(int id);

    Product updateProduct(Product product);

    void deleteProduct(Product product);

    void addProduct(Product product);

}
