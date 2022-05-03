package com.restsoap.api.exceptions.exception_mapper;

import com.restsoap.api.exceptions.dto.ExceptionErrorMessage;
import com.restsoap.api.exceptions.types.NotFoundResourcesExce;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

import jakarta.ws.rs.ext.Provider;
@Provider
public class NotFoundExceMapper implements ExceptionMapper<NotFoundResourcesExce> {

    @Override
    public Response toResponse(NotFoundResourcesExce exception) {
                
        ExceptionErrorMessage errorMessage = new ExceptionErrorMessage(exception.getMessage(), 404, "probably wrong ID");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}
