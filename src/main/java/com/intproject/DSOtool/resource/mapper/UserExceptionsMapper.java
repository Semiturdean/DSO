package com.intproject.DSOtool.resource.mapper;

import com.intproject.DSOtool.service.exceptions.UserExceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Collections;

@Provider
public class UserExceptionsMapper implements ExceptionMapper<UserExceptions> {
    @Override
    public Response toResponse(UserExceptions userExceptions) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(Collections.singletonMap("error", userExceptions.getMessage()))
                .build();
    }
}
