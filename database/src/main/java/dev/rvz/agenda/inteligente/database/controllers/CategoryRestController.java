package dev.rvz.agenda.inteligente.database.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.rvz.agenda.inteligente.database.controllers.contract.CategoryRestControllerable;
import dev.rvz.agenda.inteligente.database.dtos.CreateCategoryDTO;
import dev.rvz.agenda.inteligente.database.entities.Category;
import dev.rvz.agenda.inteligente.database.services.CategoryService;

@RestController
@RequestMapping(path = "/categories")
class CategoryRestController implements CategoryRestControllerable {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryRestController.class);
	private final CategoryService categoryService;

	public CategoryRestController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Category create(@RequestBody CreateCategoryDTO createCategoryDTO) {
		LOGGER.info("create - input createCategoryDTO: {}", createCategoryDTO);
		return this.categoryService.create(createCategoryDTO.convertDTOToEntityCategory());
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Category> getAll() {
		Iterable<Category> categories = this.categoryService.getAll();
		LOGGER.info("getAll - categories: {}", categories);
		return categories;
	}
}
