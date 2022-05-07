package com.restsoap.api.controllers.beans;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductBean {
    @XmlAttribute

    private Integer id;
    private CategoryBean category;
    private String name;
    private String quantity;
    private String state;
    private Double price;
    // private Set<CartBean> carts = new HashSet<CartBean>(0);
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private List<Link> links;

    public ProductBean() {
    }

    // public ProductBean(Integer id, CategoryBean category, String name, String
    // quantity, String state, Double price,
    // Set<CartBean> carts) {
    // this.id = id;
    // this.category = category;
    // this.name = name;
    // this.quantity = quantity;
    // this.state = state;
    // this.price = price;
    // this.carts = carts;
    // }

    public ProductBean(Integer id, CategoryBean category, String name, String quantity, String state, Double price) {
        this.id = id;
        // this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.state = state;
        this.price = price;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductBean [category=" + category + ", id=" + id + ", name=" + name + ", price="
                + price + ", quantity=" + quantity + ", state=" + state + ", links=" + links + "]";
    }

    // public Set<CartBean> getCarts() {
    // return carts;
    // }

    // public void setCarts(Set<CartBean> carts) {
    // this.carts = carts;
    // }

}
