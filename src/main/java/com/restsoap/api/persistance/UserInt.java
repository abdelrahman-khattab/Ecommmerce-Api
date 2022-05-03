package com.restsoap.api.persistance;

import java.util.List;

import com.restsoap.api.entities.User;

public interface UserInt {
    List<User> getAllUsers();

    User getUser(int id);

    User updateUser(User user);

    void deleteUser(User user);

    void addUser(User user);
}
