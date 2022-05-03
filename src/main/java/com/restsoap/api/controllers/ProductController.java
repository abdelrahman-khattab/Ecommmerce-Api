package com.restsoap.api.controllers;

import java.util.List;

import com.restsoap.api.entities.Product;
import com.restsoap.api.exceptions.types.NotFoundResourcesExce;
import com.restsoap.api.services.impl.ProductServicesImpl;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("products")
public class ProductController {
    @GET
    @Path("{id}")
    @Produces({ "application/xml", "application/json" })
    public Product getCustomerByID(@PathParam("id") int id) {
        Product product = new ProductServicesImpl().getProduct(id);
        if (product == null) {
            throw new NotFoundResourcesExce("Product with ID:" + id + " Not Found");
        }
        return product;
    }

    @GET
    @Produces({ "application/xml", "application/json" })
    public List<Product> getCustomerAll() {
        List<Product> products = new ProductServicesImpl().getAllProducts();
        if (products == null) {
            throw new NotFoundResourcesExce("There is no Products Yet");
        }
        return products;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public String addUser(Product product) {
        new ProductServicesImpl().addProduct(product);
        return "Product added";
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public String updateUser(Product product) {
        Product product1 = new ProductServicesImpl().getProduct(product.getId());
        if (product1 == null) {
            throw new NotFoundResourcesExce("Product with ID:" + product.getId() + " Not Found");
        }
        new ProductServicesImpl().updateProduct(product);
        return "product updated";
    }

    @DELETE
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public String deleteUser(@PathParam("id") int id) {
        Product product1 = new ProductServicesImpl().getProduct(id);
        if (product1 == null) {
            throw new NotFoundResourcesExce("Product with ID:" + id + " Not Found");
        }
        new ProductServicesImpl().deleteProduct(product1);
        return "Product Deleted";
    }
}
