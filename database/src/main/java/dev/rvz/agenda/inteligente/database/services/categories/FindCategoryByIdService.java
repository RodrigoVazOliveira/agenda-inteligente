package dev.rvz.agenda.inteligente.database.services.categories;

import dev.rvz.agenda.inteligente.database.entities.Category;
import dev.rvz.agenda.inteligente.database.exceptions.categories.CategoryNotFoundException;
import dev.rvz.agenda.inteligente.database.repositories.CategoryRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.categories.FindCategoryByIdServiceable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FindCategoryByIdService implements FindCategoryByIdServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(FindCategoryByIdService.class);
	private final CategoryRepository categoryRepository;

	public FindCategoryByIdService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Transactional
	@Override
	public Category execute(Long id) {
		LOGGER.info("execute input id: {}", id);
		Optional<Category> categoryOptional = this.categoryRepository.findById(id);
		categoryNotFound(id, categoryOptional);
		Category category = categoryOptional.get();
		LOGGER.info("execute - output category: {}", category);

		return category;
	}

	private void categoryNotFound(Long id, Optional<Category> categoryOptional) {
		if (categoryOptional.isEmpty()) {
			throw new CategoryNotFoundException("Categoria com id " + id + "nao existe!");
		}
	}

}
