package com.restsoap.api.controllers;

import java.util.Arrays;
import java.util.List;

import com.restsoap.api.controllers.beans.ProductBean;
import com.restsoap.api.entities.Product;
import com.restsoap.api.exceptions.types.NotFoundResourcesExce;
import com.restsoap.api.services.impl.ProductServicesImpl;
import com.restsoap.api.utils.mappers.ProductMapper;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("products")
public class ProductController {
    @GET
    @Path("product/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getProductByID(@PathParam("id") int id, @Context UriInfo uriInfo) {
        Product product = new ProductServicesImpl().getProduct(id);
        if (product == null) {
            throw new NotFoundResourcesExce("Product with ID:" + id + " Not Found");
        }
        ProductBean bean = ProductMapper.INSTANCE.productEntityToBean(product);
        bean.setLinks(getLinks(uriInfo));
        return Response.ok(bean).build();

    }

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getAllProduct(@Context UriInfo uriInfo) {
        System.out.println("enter getallproduct");
        List<Product> products = new ProductServicesImpl().getAllProducts();
        System.out.println("collected getallproduct" + products);
        if (products == null) {
            throw new NotFoundResourcesExce("There is no Products Yet");
        }
        return Response.ok(ProductMapper.INSTANCE.listEntitiesToBeans(products)).build();

    }

    @POST
    @Path("add")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response addProduct(Product product, @Context UriInfo uriInfo) {
        new ProductServicesImpl().addProduct(product);
        return Response.ok(Arrays.asList("Product added", getLinks(uriInfo))).build();

    }

    @PUT
    @Path("update")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response updateProduct(Product product, @Context UriInfo uriInfo) {
        Product product1 = new ProductServicesImpl().getProduct(product.getId());
        if (product1 == null) {
            throw new NotFoundResourcesExce("Product with ID:" + product.getId() + " Not Found");
        }
        new ProductServicesImpl().updateProduct(product);
        return Response.ok(Arrays.asList("Product Update", getLinks(uriInfo))).build();
    }

    @DELETE
    @Path("delete/{id}")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response deleteProduct(@PathParam("id") int id, @Context UriInfo uriInfo) {
        Product product1 = new ProductServicesImpl().getProduct(id);
        if (product1 == null) {
            throw new NotFoundResourcesExce("Product with ID:" + id + " Not Found");
        }
        new ProductServicesImpl().deleteProduct(product1);
        return Response.ok(Arrays.asList("Product Deleted", getLinks(uriInfo))).build();
    }

    List<Link> getLinks(UriInfo uriInfo) {

        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link allProducts = Link.fromUriBuilder(uriInfo.getBaseUriBuilder().path(ProductController.class))
                .rel("AllProducts")
                .build();
        Link updateProduct = Link
                .fromUriBuilder(uriInfo.getBaseUriBuilder().path(ProductController.class).path("update"))
                .rel("UpdateProduct").build();
        Link deleteProduct = Link
                .fromUriBuilder(uriInfo.getBaseUriBuilder().path(ProductController.class).path("delete"))
                .rel("DeleteProduct").build();
        Link addProduct = Link.fromUriBuilder(uriInfo.getBaseUriBuilder().path(ProductController.class).path("add"))
                .rel("AddProduct").build();
        Link getSingleProduct = Link
                .fromUriBuilder(uriInfo.getBaseUriBuilder().path(ProductController.class).path("user"))
                .rel("GetProduct").build();

        return Arrays.asList(allProducts, self, deleteProduct, getSingleProduct, updateProduct, addProduct);

    }

}
