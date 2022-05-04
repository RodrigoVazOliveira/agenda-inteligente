package dev.rvz.agenda.inteligente.webservice.controllers;

import dev.rvz.agenda.inteligente.webservice.controllers.port.CategoryRestControllerPort;
import dev.rvz.agenda.inteligente.webservice.dtos.CategoryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.CategoryResponseDTO;
import dev.rvz.agenda.inteligente.webservice.service.port.CreateCategoryServicePort;
import dev.rvz.agenda.inteligente.webservice.service.port.GetAllCategoriesServicePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
class CategoryRestController implements CategoryRestControllerPort {
	private final static Logger LOGGER = LoggerFactory.getLogger(CategoryRestController.class);
	private final CreateCategoryServicePort createCategoryService;
	private final GetAllCategoriesServicePort getAllCategoriesService;

	public CategoryRestController(CreateCategoryServicePort createCategoryService,
			GetAllCategoriesServicePort getAllCategoriesService) {
		this.createCategoryService = createCategoryService;
		this.getAllCategoriesService = getAllCategoriesService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Override
	public CategoryResponseDTO create(@RequestBody @Valid CategoryRequestDTO categoryRequestDTO) {
		LOGGER.info("create - categoryRequestDTO: {}", categoryRequestDTO);
		CategoryResponseDTO categoryResponseDTO = this.createCategoryService.run(categoryRequestDTO);
		LOGGER.info("create - categoryResponseDTO: {}", categoryResponseDTO);

		return categoryResponseDTO;
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	@Override
	public Iterable<CategoryResponseDTO> getAll() {
		LOGGER.info("getall - searching categories");
		return this.getAllCategoriesService.run();
	}


}