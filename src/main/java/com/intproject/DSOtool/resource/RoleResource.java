package com.intproject.DSOtool.resource;


import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.repositories.RoleRepository;
import com.intproject.DSOtool.repositories.UserRepository;
import com.intproject.DSOtool.service.RoleService;
import com.intproject.DSOtool.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("roles")
public class RoleResource {

    @Context
    private UriInfo uriInfo;

    /*@Autowired
    private RoleRepository roleRepository;
    @Autowired+
    private UserRepository userRepository; */
    @Autowired
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
}

