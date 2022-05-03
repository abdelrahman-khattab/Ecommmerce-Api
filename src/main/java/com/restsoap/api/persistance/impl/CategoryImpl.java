package com.restsoap.api.persistance.impl;

import java.util.List;

import com.restsoap.api.entities.Category;
import com.restsoap.api.persistance.CategoryInt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoryImpl implements CategoryInt {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restSoap");;

    @Override
    public List<Category> getAllCategories() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Category> resultList = (List<Category>) entityManager.createQuery("FROM " + Category.class.getSimpleName())
                .getResultList();
        return resultList;
    }

    @Override
    public Category getCategory(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Category category = entityManager.find(Category.class, id);
        entityManager.close();
        return category;
    }

    @Override
    public Category updateCategory(Category category) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(category);
        entityManager.getTransaction().commit();
        entityManager.close();
        return category;
    }

    @Override
    public void deleteCategory(Category category) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void addCategory(Category category) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
    }

}
