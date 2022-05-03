package com.restsoap.api.services.impl;

import java.util.List;

import com.restsoap.api.entities.User;
import com.restsoap.api.persistance.impl.UserImpl;
import com.restsoap.api.services.UserServicesInt;

public class UserServicesImpl implements UserServicesInt {

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return new UserImpl().getAllUsers();
    }

    @Override
    public User getUser(int id) {
        // TODO Auto-generated method stub
        return new UserImpl().getUser(id);
    }

    @Override
    public User updateUser(User user) {
        // TODO Auto-generated method stub
        return new UserImpl().updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        // TODO Auto-generated method stub
        new UserImpl().deleteUser(user);
    }

    @Override
    public void addUser(User user) {
        // TODO Auto-generated method stub
        new UserImpl().addUser(user);

    }

}
