package com.restsoap.api.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.restsoap.api.controllers.beans.UserBean;
import com.restsoap.api.entities.User;
import com.restsoap.api.exceptions.types.NotFoundResourcesExce;
import com.restsoap.api.services.impl.UserServicesImpl;
import com.restsoap.api.utils.mappers.UserMapper;

import org.mapstruct.Mapper;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("users")
public class UserController {
    @GET
    @Path("user/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getCustomerByID(@PathParam("id") int id, @Context UriInfo uriInfo) {
        User user = new UserServicesImpl().getUser(id);
        if (user == null) {
            throw new NotFoundResourcesExce("User with ID:" + id + " Not Found");
        }
        UserBean bean = UserMapper.INSTANCE.userEntityToBean(user);
        bean.setLinks(getLinks(uriInfo));

        return Response.ok(bean).build();

    }

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getCustomerAll(@Context UriInfo uriInfo) {
        List<User> users = new UserServicesImpl().getAllUsers();
        if (users.size() < 1) {
            throw new NotFoundResourcesExce(" " + 404 + "There is no users yest");
        }
        // GenericEntity entity = new GenericEntity<List<UserBean>>(
        // UserMapper.INSTANCE.listEntitiesToBeans(users)) {
        // };
        return Response.ok(UserMapper.INSTANCE.listEntitiesToBeans(users)).build();
    }

    @POST
    @Path("add")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response addUser(UserBean user, @Context UriInfo uriInfo) {
        new UserServicesImpl().addUser(UserMapper.INSTANCE.userBeanToEntity(user));
        return Response.ok(Arrays.asList("user added", getLinks(uriInfo))).build();
    }

    @PUT
    @Path("update")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response updateUser(UserBean user, @Context UriInfo uriInfo) {
        User user1 = new UserServicesImpl().getUser(user.getId());
        if (user1 == null) {
            throw new NotFoundResourcesExce("User with ID:" + user.getId() + " Not Found");
        }
        new UserServicesImpl().updateUser(UserMapper.INSTANCE.userBeanToEntity(user));

        return Response.ok(Arrays.asList("user updated", getLinks(uriInfo))).build();

    } 

    @DELETE
    @Path("delete/{id}")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response deleteUser(@PathParam("id") int id, @Context UriInfo uriInfo) {
        User user1 = new UserServicesImpl().getUser(id);
        if (user1 == null) {
            throw new NotFoundResourcesExce("User with ID:" + id + " Not Found");
        }
        new UserServicesImpl().deleteUser(user1);

        return Response.ok(Arrays.asList("user Deleted", getLinks(uriInfo))).build();

    }

    List<Link> getLinks(UriInfo uriInfo) {

        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link allUsers = Link.fromUriBuilder(uriInfo.getBaseUriBuilder().path(UserController.class)).rel("AllUser")
                .build();
        Link updateUsers = Link.fromUriBuilder(uriInfo.getBaseUriBuilder().path(UserController.class).path("update"))
                .rel("UpdateUser").build();
        Link deleteUsers = Link.fromUriBuilder(uriInfo.getBaseUriBuilder().path(UserController.class).path("delete"))
                .rel("DeleteUser").build();
        Link addUsers = Link.fromUriBuilder(uriInfo.getBaseUriBuilder().path(UserController.class).path("add"))
                .rel("AddUser").build();
        Link getSingleUser = Link.fromUriBuilder(uriInfo.getBaseUriBuilder().path(UserController.class).path("user"))
                .rel("GetUser").build();

        return Arrays.asList(allUsers, self, deleteUsers, getSingleUser, updateUsers, addUsers);

    }
}
