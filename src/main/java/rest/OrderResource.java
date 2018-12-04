/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.CustomerOrder;
import facade.OrderFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author alber
 */
@Path("order")
public class OrderResource {

    @Context
    private UriInfo context;
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    OrderFacade orderFacade = new OrderFacade();

    /**
     * Creates a new instance of OrderResource
     */
    public OrderResource() {
    }

    /**
     * Retrieves representation of an instance of rest.OrderResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders() {
        return Response.ok().entity(gson.toJson(orderFacade.getAllOrders())).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)    
    public Response getCandyById(@PathParam("id") int id){
        return Response.ok().entity(gson.toJson(orderFacade.getOrderByOrderId(id))).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(String content) {
        CustomerOrder newOrder = gson.fromJson(content, CustomerOrder.class);
        System.out.println("newCandy: " + newOrder);
        orderFacade.createOrder(newOrder);
        return Response.ok().entity(gson.toJson(newOrder)).build();
    }
    
    /**
     * PUT method for updating or creating an instance of OrderResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}