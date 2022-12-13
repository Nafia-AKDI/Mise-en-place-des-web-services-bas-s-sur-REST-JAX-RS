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
import ma.fstt.model.Station;
import ma.fstt.persistence.CarburantOperations;
import ma.fstt.persistence.StationOperations;

@Path("/Station")
public class StationService {
	StationOperations productOperations;
	public StationService() {
		super();
		// TODO Auto-generated constructor stub
		 productOperations = new StationOperations();

	}

	 @GET
	    @Path("/get/{id}")
	    @Produces("get/json")
	    public Response get(@PathParam("id") Long Id) {
	            return Response.ok(productOperations.findStation(Id)).build();
	 }

    @POST
    @Path("/add")
    @Consumes("add/json")
    @Produces("add/json")
    public Response add(Station s) {
			productOperations.persistStation(s);
		return Response.status(Response.Status.CREATED).entity(s).build();

	}
	
	
	@Path("/all")
	@GET
	public Response All() {
		return Response.ok(productOperations.getAllStations()).build();
	}
	
	
	
	 @DELETE
	    @Path("/delete")
	    @Consumes("delete/json")
	    @Produces("delete/json")
	    public Response delete(Station s) {
	            return Response.ok(productOperations.deleteProduct(s)).build();
	 }

}
