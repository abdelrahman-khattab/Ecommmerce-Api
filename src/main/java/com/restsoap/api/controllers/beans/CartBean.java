package com.restsoap.api.controllers.beans;

public class CartBean {
    private Integer id;
    private ProductBean product;
    private UserBean user;

    public CartBean() {
    }

    public CartBean(Integer id, ProductBean product, UserBean user) {
        this.id = id;
        this.product = product;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CartBean [id=" + id + ", product=" + product + ", user=" + user + "]";
    }

}
