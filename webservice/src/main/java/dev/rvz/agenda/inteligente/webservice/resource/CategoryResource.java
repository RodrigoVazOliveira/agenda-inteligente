package dev.rvz.agenda.inteligente.webservice.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/categories")
@Produces(value = MediaType.APPLICATION_JSON)
public class CategoryResource {

	@GET
	public Response getCategories() {
		return Response.ok("{\"name\":\"asdfs\"}", MediaType.APPLICATION_JSON).build();
	}
}
