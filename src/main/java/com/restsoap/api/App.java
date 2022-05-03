package com.restsoap.api;

import com.restsoap.api.controllers.beans.ProductBean;
import com.restsoap.api.entities.Product;
import com.restsoap.api.entities.User;
import com.restsoap.api.persistance.CategoryInt;
import com.restsoap.api.persistance.ProductInt;
import com.restsoap.api.persistance.UserInt;
import com.restsoap.api.persistance.impl.CategoryImpl;
import com.restsoap.api.persistance.impl.ProductImpl;
// import com.restsoap.api.utils.mappers.ProductMapper;
import com.restsoap.api.persistance.impl.UserImpl;

public class App {
    public static void main(String[] args) {
        ProductInt productInt = new ProductImpl();
        CategoryInt categoryInt = new CategoryImpl();
        UserInt userInt = new UserImpl();
        // Product product = new Product(categoryInt.getCategory(1), "Ball", "5",
        //         "in-stock", 150.0);
        // productInt.addProduct(product);
        // Product product = productInt.getProduct(1);
        // product.setName("tennis ball");
        // product = productInt.updateProduct(product);

            // User user = new User("email@email.com");
            // userInt.addUser(user);

        // ProductBean productBean =
        // ProductMapper.INSTANCE.productEntityToBean(product);

        // System.out.println("Product" + productBean.getName());

    }
}
