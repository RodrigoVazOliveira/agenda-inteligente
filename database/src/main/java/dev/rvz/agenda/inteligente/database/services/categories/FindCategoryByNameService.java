package dev.rvz.agenda.inteligente.database.services.categories;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.rvz.agenda.inteligente.database.entities.Category;
import dev.rvz.agenda.inteligente.database.exceptions.CategorByNameNotFoundException;
import dev.rvz.agenda.inteligente.database.repositories.CategoryRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.FindCategoryByNameServiceable;

@Service
public class FindCategoryByNameService implements FindCategoryByNameServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(FindCategoryByNameService.class);
	private final CategoryRepository categoryRepository;

	public FindCategoryByNameService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category execute(String name) {
		LOGGER.info("execute input name: {}", name);
		Category category = findByName(name);
		LOGGER.info("execute - output category: {}", category);

		return category;
	}

	private Category findByName(String name) throws CategorByNameNotFoundException {
		Optional<Category> categoryOptinal = this.categoryRepository.findByName(name);
		findByNamIsEmpty(name, categoryOptinal);

		return categoryOptinal.get();
	}

	private void findByNamIsEmpty(String name, Optional<Category> categoryOptinal)
			throws CategorByNameNotFoundException {
		if (categoryOptinal.isEmpty()) {
			LOGGER.error("findByNamIsEmpty - cateria com nome " + name + " nao existe!");
			throw new CategorByNameNotFoundException("Catgoria com nome " + name + " nao existe!");
		}
	}

}
