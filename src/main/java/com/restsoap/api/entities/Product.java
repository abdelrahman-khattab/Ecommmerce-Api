// default package
// Generated Apr 25, 2022, 7:19:32 PM by Hibernate Tools 6.0.0.Beta2
package com.restsoap.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */
@XmlRootElement
@Entity
@Table(name = "product", catalog = "rest_soap")
public class Product implements java.io.Serializable {

    private Integer id;
    private Category category;
    private String name;
    private String quantity;
    private String state;
    private Double price;
    private Set<Cart> carts = new HashSet<Cart>(0);

    public Product() {
    }

    public Product(Category category, String name, String quantity, String state, Double price) {
        this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.state = state;
        this.price = price;
    }

    public Product(Category category) {
        this.category = category;
    }

    public Product(Category category, String name, String quantity, String state, Double price, Set<Cart> carts) {
        this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.state = state;
        this.price = price;
        this.carts = carts;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "name", length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "quantity", length = 45)
    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Column(name = "state", length = 45)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "price", precision = 22, scale = 0)
    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<Cart> getCarts() {
        return this.carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "Product [carts=" + carts + ", category=" + category + ", id=" + id + ", name=" + name + ", price="
                + price + ", quantity=" + quantity + ", state=" + state + "]";
    }

}
