/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fetchstarwars.FetchThreadSWAPI;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.ExecutionException;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * REST Web Service
 *
 * @author Mads
 */
@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;
    
    @Context
    SecurityContext securityContext;
    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PersonResource
     * @return an instance of java.lang.String
     */
    @GET
    @RolesAllowed({"user", "admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() throws InterruptedException, IOException, ProtocolException, ExecutionException {
        FetchThreadSWAPI ft = new FetchThreadSWAPI();
        return Response.ok().entity(ft.fetchStuff()).build();
    }

    @GET
    @Path("unprotected")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUnprotectedJson() throws InterruptedException, IOException, ProtocolException, ExecutionException {
        FetchThreadSWAPI ft = new FetchThreadSWAPI();
        return Response.ok().entity(ft.fetchStuff()).build();
    }
    /**
     * PUT method for updating or creating an instance of PersonResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
