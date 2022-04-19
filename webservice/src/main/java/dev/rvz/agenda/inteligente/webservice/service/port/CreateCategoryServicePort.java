package dev.rvz.agenda.inteligente.webservice.service.port;

import dev.rvz.agenda.inteligente.webservice.dtos.CategoryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.CategoryResponseDTO;

public interface CreateCategoryServicePort {
	CategoryResponseDTO run(CategoryRequestDTO categoryRequestDTO);
}
