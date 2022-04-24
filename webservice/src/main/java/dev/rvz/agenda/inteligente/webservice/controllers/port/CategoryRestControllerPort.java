package dev.rvz.agenda.inteligente.webservice.controllers.port;

import dev.rvz.agenda.inteligente.webservice.dtos.CategoryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.CategoryResponseDTO;

public interface CategoryRestControllerPort {

	CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO);
}
