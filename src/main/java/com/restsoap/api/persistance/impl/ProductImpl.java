package com.restsoap.api.persistance.impl;

import java.util.List;

import com.restsoap.api.entities.Product;
import com.restsoap.api.persistance.ProductInt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductImpl implements ProductInt {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restSoap");;

    @Override
    public List<Product> getAllProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Product> resultList = (List<Product>) entityManager.createQuery("FROM " + Product.class.getSimpleName())
                .getResultList();
        return resultList;
    }

    @Override
    public Product getProduct(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Product product = entityManager.find(Product.class, id);
        entityManager.close();
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    @Override
    public void deleteProduct(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void addProduct(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        product.setCategory(new CategoryImpl().getCategory(product.getCategory().getId()));
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

}
