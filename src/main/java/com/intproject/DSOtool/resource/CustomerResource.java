package com.intproject.DSOtool.resource;


import com.intproject.DSOtool.data.Customer;
import com.intproject.DSOtool.service.CustomerServiceImpl;
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
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Path("customers")
public class CustomerResource {

    @Context
    private UriInfo uriInfo;

    private final CustomerServiceImpl service;


    public CustomerResource(CustomerServiceImpl service) {
        this.service = service;
    }

    @POST
    public Response createCustomer(Customer customer){
        Customer createNewCustomer = service.createNewCustomer(customer);

        return Response.status(Response.Status.CREATED).header("Location",
                uriInfo.getAbsolutePathBuilder().path(createNewCustomer.getId().toString())).build();
    }
}

