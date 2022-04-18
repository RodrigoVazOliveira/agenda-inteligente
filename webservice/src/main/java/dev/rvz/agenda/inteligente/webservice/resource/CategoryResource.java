package dev.rvz.agenda.inteligente.webservice.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.rvz.agenda.inteligente.webservice.dtos.CategoryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.CategoryResponseDTO;
import dev.rvz.agenda.inteligente.webservice.rest.databases.CategoryDatabaseRest;
import feign.FeignException;

@Path("/categories")
@Produces(value = MediaType.APPLICATION_JSON)
public class CategoryResource {
	private final static Logger LOGGER = LoggerFactory.getLogger(CategoryResource.class);
	private final CategoryDatabaseRest categoryDatabaseRest;

	public CategoryResource(CategoryDatabaseRest categoryDatabaseRest) {
		this.categoryDatabaseRest = categoryDatabaseRest;
	}

	@GET
	public Response getCategories() {
		LOGGER.info("getCategories - buscando dados na api");
		try {
			Iterable<CategoryResponseDTO> categories = this.categoryDatabaseRest.getAll();
			LOGGER.info("getCategories - response categories: {}", categories);
			return Response.ok(categories, MediaType.APPLICATION_JSON).build();
		} catch (FeignException e) {
			LOGGER.error("getCategories - body: {}", e.responseBody());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.responseBody()).build();
		}
	}

	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response create(CategoryRequestDTO categoryRequestDTO) {
		LOGGER.info("create - categoryRequestDTO: {}", categoryRequestDTO);
		try {
			CategoryResponseDTO categoryResponseDTO = this.categoryDatabaseRest.create(categoryRequestDTO);
			return Response.status(Status.CREATED).entity(categoryResponseDTO).build();
		} catch (FeignException e) {
			LOGGER.error("create - body: {}", e.responseBody());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.responseBody()).build();
		}
	}
}
