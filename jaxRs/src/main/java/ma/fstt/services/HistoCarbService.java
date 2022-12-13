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
import ma.fstt.model.HistoCarb;
import ma.fstt.persistence.CarburantOperations;
import ma.fstt.persistence.HistoCrbOperations;

@Path("/HistoCarb")
public class HistoCarbService {
	HistoCrbOperations productOperations;
	public HistoCarbService() {
		super();
		// TODO Auto-generated constructor stub
		 productOperations = new HistoCrbOperations();

	}

	 @GET
	    @Path("/get/{id}")
	    @Produces("get/json")
	    public Response get(@PathParam("id") Long Id) {
	            return Response.ok(productOperations.findHistoCarb(Id)).build();
	 }

    @POST
    @Path("/add")
    @Consumes("add/json")
    @Produces("add/json")
    public Response add(HistoCarb h) {
			productOperations.persistHistoCarb(h);
		return Response.status(Response.Status.CREATED).entity(h).build();

	}
	
	
	@Path("/all")
	@GET
	public Response All() {
		return Response.ok(productOperations.getHistoCarb()).build();
	}
	
	
	
	 @DELETE
	    @Path("/delete")
	    @Consumes("delete/json")
	    @Produces("delete/json")
	    public Response delete(HistoCarb h) {
	            return Response.ok(productOperations.deleteHistoCarb(h)).build();
	 }

}
