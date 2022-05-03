package com.restsoap.api.controllers.beans;

import java.util.HashSet;
import java.util.Set;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserBean {
    private Integer id;
    private String name;
    private String gender;
    private String email;
    private String password;
    private String type;
    private Set<CartBean> carts = new HashSet<CartBean>(0);

    public UserBean(Integer id, String name, String gender, String email, String password, String type,
            Set<CartBean> carts) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.type = type;
        this.carts = carts;
    }

    public UserBean() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<CartBean> getCarts() {
        return carts;
    }

    public void setCarts(Set<CartBean> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "UserBean [carts=" + carts + ", email=" + email + ", gender=" + gender + ", id=" + id + ", name=" + name
                + ", password=" + password + ", type=" + type + "]";
    }

}
