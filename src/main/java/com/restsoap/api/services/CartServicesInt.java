package com.restsoap.api.services;

import java.util.List;

import com.restsoap.api.entities.Cart;

public interface CartServicesInt {
    List<Cart> getAllCarts();

    Cart getCart(int id);

    Cart updateCart(Cart cart);

    void deleteCart(Cart cart);

    void addCart(Cart cart);
}
