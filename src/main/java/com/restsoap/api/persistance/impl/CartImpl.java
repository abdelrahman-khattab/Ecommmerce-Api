package com.restsoap.api.persistance.impl;

import java.util.List;

import com.restsoap.api.entities.Cart;
import com.restsoap.api.persistance.CartInt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CartImpl implements CartInt {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restSoap");;

    @Override
    public List<Cart> getAllCarts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Cart> resultList = (List<Cart>) entityManager.createQuery("FROM " 
                + Cart.class.getSimpleName())
                .getResultList();
        return resultList;
    }

    @Override
    public Cart getCart(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Cart cart = entityManager.find(Cart.class, id);
        entityManager.close();
        return cart;
    }

    @Override
    public Cart updateCart(Cart cart) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(cart);
        entityManager.getTransaction().commit();
        entityManager.close();
        return cart;
    }

    @Override
    public void deleteCart(Cart cart) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(cart) ? cart : entityManager.merge(cart));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void addCart(Cart cart) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cart);
        entityManager.getTransaction().commit();
    }

}
