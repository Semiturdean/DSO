package com.intproject.DSOtool.resource;


import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.service.CustomUserDetailService;
import com.intproject.DSOtool.service.UserService;
import com.intproject.DSOtool.service.UserServiceImpl;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Path("users")
public class UserResource {

    @Context
    private UriInfo uriInfo;

    private UserService userService;
    private CustomUserDetailService customUserDetailService;


    public UserResource(UserServiceImpl userService, CustomUserDetailService customUserDetailService) {
        this.userService = userService;
        this.customUserDetailService = customUserDetailService;
    }

    @POST
    public Response createUser(User user){
        User createNewUserAccount = userService.createNewUserAccount(user);

        return Response.status(Response.Status.CREATED).header("Location",
                uriInfo.getAbsolutePathBuilder().path(createNewUserAccount.getId().toString())).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUserById(@PathParam("id") Long id){
        if(userService.findUserById(id).isPresent()) {
            userService.deleteUserById(id);
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("{id}")
    public Response getUserById(@PathParam("id") Long id){
        return userService.findUserById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }
}
