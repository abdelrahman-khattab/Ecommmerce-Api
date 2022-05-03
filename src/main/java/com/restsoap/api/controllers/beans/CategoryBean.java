package com.restsoap.api.controllers.beans;

import java.util.HashSet;
import java.util.Set;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CategoryBean {
    private Integer id;
    private String name;
    private Set<ProductBean> products = new HashSet<ProductBean>(0);

    public CategoryBean() {
    }

    public CategoryBean(Integer id, String name, Set<ProductBean> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductBean> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductBean> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategoryBean [id=" + id + ", name=" + name + ", products=" + products + "]";
    }

}
