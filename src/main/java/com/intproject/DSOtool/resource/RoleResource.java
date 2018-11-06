package com.intproject.DSOtool.resource;

import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.User;
import com.intproject.DSOtool.service.RoleService;
import com.intproject.DSOtool.service.UserService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;

@Component
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("roles")
public class RoleResource {

    @Context
    private UriInfo uriInfo;

    private RoleService roleService;

    public RoleResource(RoleService roleService) {
        this.roleService = roleService;
    }

    @POST
    public Response createRole(Role role){
        Role createNewRole = roleService.createNewRole(role);

        return Response.status(Response.Status.CREATED).header("Location",
                uriInfo.getAbsolutePathBuilder().path(createNewRole.getId().toString())).build();
    }
    @PUT
    @Path("{id}/users/{userid}")
    public Response assignRoleToUser(@PathParam("id") Long id,
                                  @PathParam("userid") Long userid) {
        roleService.assignRoleToUser(id, userid);
        return Response.status(OK).build();
    }

}
