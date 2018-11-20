package com.intproject.DSOtool.resource;


import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private RoleService roleService;
    private CustomUserDetailService customUserDetailService;


    public UserResource(UserServiceImpl userService, CustomUserDetailService customUserDetailService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.customUserDetailService = customUserDetailService;
    }

    @POST
    public Response createUser(User user){
        User createNewUserAccount = userService.createNewUserAccount(user);

        return Response.status(Response.Status.CREATED).header("Location",
                uriInfo.getAbsolutePathBuilder().path(createNewUserAccount.getId().toString())).build();
    }

    // http://localhost:8080/users/{id}
    @GET
    @Path("{id}")
    public Response getUserById(@PathParam("id") Long id){
        return userService.findUserById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    // http://localhost:8080/users/email/{email}
    @GET
    @Path("/email/{email}")
    public Response getUserByEmailAddress(@PathParam("email") String email){
        return userService.findByEmail(email)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    // http://localhost:8080/users/firstname/{firstname}
    @GET
    @Path("/firstname/{firstname}")
    public Response getUsersByFirstName(@PathParam("firstname") String firstName){
        List<User> users = userService.findByFirstName(firstName);
        GenericEntity<List<User>> list = new GenericEntity<List<User>>(users){};
        return Response.ok(list).build();
    }

    // http://localhost:8080/users/lastname/{lastname}
    @GET
    @Path("/lastname/{lastname}")
    public Response getUsersByLastName(@PathParam("lastname") String lastName){
        List<User> users = userService.findByLastName(lastName);
        GenericEntity<List<User>> list = new GenericEntity<List<User>>(users){};
        return Response.ok(list).build();
    }

    // http://localhost:8080/users/role?roles={role1}&roles={role2}
    @GET
    @Path("/roles")
    public Response getUserByRole(@QueryParam("roles") List<String> stringRoles){
        List<Role> roles = new ArrayList<>();
        for (String role : stringRoles) {
            Role roleObject = roleService.findByRole(role);
            roles.add(roleObject);
        }
        Map<Role, List<User>> users = userService.findAllByRoles(roles);
        GenericEntity<Map<Role, List<User>>> list = new GenericEntity<Map<Role ,List<User>>>(users){};
        return Response.ok(list).build();
    }

    // http://localhost:8080/users/{id}
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
