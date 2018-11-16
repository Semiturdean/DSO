package com.intproject.DSOtool.resource;


import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.service.CustomUserDetailService;
import com.intproject.DSOtool.service.UserService;
import com.intproject.DSOtool.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Path("users")
public class UserResource {

    @Context
    private UriInfo uriInfo;

    @Autowired
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

    @GET
    @Path("{id}")
    public Response getUserById(@PathParam("id") Long id){
        return userService.findUserById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @GET
    @Path("/email/{email}")
    public Response getUserByEmailAddress(@PathParam("email") String email){
        return userService.findByEmail(email)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @GET
    @Path("/firstname/{firstname}")
    public Response getUsersByFirstName(@PathParam("firstname") String firstName){
        List<User> users = userService.findByFirstName(firstName);
        GenericEntity<List<User>> list = new GenericEntity<List<User>>(users){};
        return Response.ok(list).build();
    }

    @GET
    @Path("/lastname/{lastname}")
    public Response getUsersByLastName(@PathParam("lastname") String lastName){
        List<User> users = userService.findByLastName(lastName);
        GenericEntity<List<User>> list = new GenericEntity<List<User>>(users){};
        return Response.ok(list).build();
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
}
