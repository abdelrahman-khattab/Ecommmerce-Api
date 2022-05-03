package com.restsoap.api.services;

import java.util.List;

import com.restsoap.api.entities.User;

public interface UserServicesInt {
    List<User> getAllUsers();

    User getUser(int id);

    User updateUser(User user);

    void deleteUser(User user);

    void addUser(User user);
}
