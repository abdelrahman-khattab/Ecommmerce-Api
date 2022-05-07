package com.restsoap.api.services.impl;

import java.util.List;

import com.restsoap.api.entities.Cart;
import com.restsoap.api.persistance.impl.CartImpl;
import com.restsoap.api.services.CartServicesInt;

public class CartServicesImpl implements CartServicesInt {

    @Override
    public List<Cart> getAllCarts() {
        // TODO Auto-generated method stub
        return new CartImpl().getAllCarts();
    }

    @Override
    public Cart getCart(int id) {
        // TODO Auto-generated method stub
        return new CartImpl().getCart(id);
    }

    @Override
    public Cart updateCart(Cart cart) {
        // TODO Auto-generated method stub
        return new CartImpl().updateCart(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        // TODO Auto-generated method stub
        new CartImpl().deleteCart(cart);
    }

    @Override
    public void addCart(Cart cart) {
        // TODO Auto-generated method stub
        new CartImpl().addCart(cart);
    }

}
