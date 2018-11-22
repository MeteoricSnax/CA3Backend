/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.CandyFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author alber
 */
@Path("candy")
public class CandyResource {

    @Context
    private UriInfo context;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    CandyFacade candyFacade = new CandyFacade();

    /**
     * Creates a new instance of CandyResource
     */
    public CandyResource() {
    }

    /**
     * Retrieves representation of an instance of rest.CandyResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return gson.toJson(candyFacade.getAllCandy());
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)    
    public String getCandyById(@PathParam("id") int id){
        //TODO return proper representation object
        return gson.toJson(candyFacade.getCandyById(id));
    }

    /**
     * PUT method for updating or creating an instance of CandyResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
