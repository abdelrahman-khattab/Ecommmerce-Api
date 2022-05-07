package com.restsoap.api.controllers.beans;

import java.util.List;

import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class CartBean {
    @XmlAttribute
    private Integer id;
    private ProductBean product;
    private UserBean user;

    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private List<Link> links;

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

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "CartBean [id=" + id + ", product=" + product + ", user=" + user + ", links=" + links + "]";
    }

}
