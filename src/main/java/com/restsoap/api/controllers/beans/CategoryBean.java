package com.restsoap.api.controllers.beans;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryBean {

    @XmlAttribute
    private Integer id;
    private String name;
    // private Set<ProductBean> products = new HashSet<ProductBean>(0);

    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private List<Link> links;

    public CategoryBean() {
    }

    public CategoryBean(Integer id, String name) {
        this.id = id;
        this.name = name;
        // this.products = products;
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

    // public Set<ProductBean> getProducts() {
    // return products;
    // }

    // public void setProducts(Set<ProductBean> products) {
    // this.products = products;
    // }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "CategoryBean [id=" + id + ", name=" + name + ", links=" + links + "]";
    }

}
