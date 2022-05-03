package com.restsoap.api.controllers;

import java.util.ArrayList;
import java.util.List;

import com.restsoap.api.entities.User;
import com.restsoap.api.exceptions.types.NotFoundResourcesExce;
import com.restsoap.api.services.impl.UserServicesImpl;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("user")
public class UserController {
    @GET
    @Path("{id}")
    @Produces({ "application/xml", "application/json" })
    public User getCustomerByID(@PathParam("id") int id) {
        User user = new UserServicesImpl().getUser(id);
        if (user == null) {
            throw new NotFoundResourcesExce("User with ID:" + id + " Not Found");
        }
        return user;
    }

    @GET
    @Produces({ "application/xml", "application/json" })
    public List<User> getCustomerAll() {
        List<User> users = new UserServicesImpl().getAllUsers();
        if (users.size() < 1) {
            throw new NotFoundResourcesExce("Order with ID:" + 404 + " Not Found");
        }
        return users;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public String addUser(User user) {
        new UserServicesImpl().addUser(user);
        return "user added";
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public String updateUser(User user) {
        User user1 = new UserServicesImpl().getUser(user.getId());
        if (user1 == null) {
            throw new NotFoundResourcesExce("User with ID:" + user.getId() + " Not Found");
        }
        new UserServicesImpl().updateUser(user);
        return "user updated";
    }

    @DELETE
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public String deleteUser(@PathParam("id") int id) {
        User user1 = new UserServicesImpl().getUser(id);
        if (user1 == null) {
            throw new NotFoundResourcesExce("User with ID:" + id + " Not Found");
        }
        new UserServicesImpl().deleteUser(user1);
        return "user Deleted";
    }
}
