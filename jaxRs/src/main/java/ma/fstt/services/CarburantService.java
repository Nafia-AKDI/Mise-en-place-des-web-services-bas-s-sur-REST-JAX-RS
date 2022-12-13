package ma.fstt.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ma.fstt.model.Carburant;
import ma.fstt.persistence.CarburantOperations;

@Path("/Carburant")
public class CarburantService {
	CarburantOperations productOperations;
	public CarburantService() {
		super();
		// TODO Auto-generated constructor stub
		 productOperations = new CarburantOperations();

	}

	 @GET
	    @Path("/get/{id}")
	    @Produces("get/json")
	    public Response get(@PathParam("id") Long Id) {
	            return Response.ok(productOperations.findCarburant(Id)).build();
	 }

    @POST
    @Path("/add")
    @Consumes("add/json")
    @Produces("add/json")
    public Response add(Carburant c) {
			productOperations.persistCarburant(c);
		return Response.status(Response.Status.CREATED).entity(c).build();

	}
	
	
	@Path("/all")
	@GET
	public Response All() {
		return Response.ok(productOperations.getAllCarburants()).build();
	}
	
	
	
	 @DELETE
	    @Path("/delete")
	    @Consumes("delete/json")
	    @Produces("delete/json")
	    public Response delete(Carburant c) {
	            return Response.ok(productOperations.deleteCarburant(c)).build();
	 }

}
