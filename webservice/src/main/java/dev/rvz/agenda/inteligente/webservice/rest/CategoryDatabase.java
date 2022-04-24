package dev.rvz.agenda.inteligente.webservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.rvz.agenda.inteligente.webservice.dtos.CategoryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.CategoryResponseDTO;

@FeignClient(url = "${url.base.categories}", name = "CategoryDatabase", value = "CategoryDatabase")
public interface CategoryDatabase {

	@PostMapping
	CategoryResponseDTO create(@RequestBody CategoryRequestDTO categoryRequestDTO);

	@GetMapping
	Iterable<CategoryResponseDTO> getAll();
}
