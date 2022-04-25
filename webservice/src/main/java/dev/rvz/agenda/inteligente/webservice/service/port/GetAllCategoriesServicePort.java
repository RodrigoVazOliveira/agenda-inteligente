package dev.rvz.agenda.inteligente.webservice.service.port;

import dev.rvz.agenda.inteligente.webservice.dtos.CategoryResponseDTO;

public interface GetAllCategoriesServicePort {
	Iterable<CategoryResponseDTO> run();
}
