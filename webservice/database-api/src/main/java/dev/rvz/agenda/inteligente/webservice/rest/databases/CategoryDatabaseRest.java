package dev.rvz.agenda.inteligente.webservice.rest.databases;

import java.util.List;

import dev.rvz.agenda.inteligente.webservice.dtos.CategoryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.CategoryResponseDTO;
import feign.Headers;
import feign.RequestLine;

@Headers("Content-Type: application/json")
public interface CategoryDatabaseRest {

	@RequestLine("POST")
	CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO);

	@RequestLine("GET")
	List<CategoryResponseDTO> getAll();
}