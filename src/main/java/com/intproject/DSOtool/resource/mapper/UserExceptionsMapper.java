package com.intproject.DSOtool.resource.mapper;

import com.intproject.DSOtool.service.exceptions.ServiceException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Collections;

@Provider
public class UserExceptionsMapper implements ExceptionMapper<ServiceException> {
    @Override
    public Response toResponse(ServiceException serviceException) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(Collections.singletonMap("error", serviceException.getMessage()))
                .build();
    }
}
