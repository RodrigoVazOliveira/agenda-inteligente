package dev.rvz.agenda.inteligente.database.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.database.entities.Category;
import dev.rvz.agenda.inteligente.database.repositories.CategoryRepository;

@Service
public class CategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category create(Category category) {
		LOGGER.info("create - category: {}", category);
		return this.categoryRepository.save(category);
	}

	public Iterable<Category> getAll() {
		return this.categoryRepository.findAll();
	}
}
