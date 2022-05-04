package dev.rvz.agenda.inteligente.database.services.categories;

import dev.rvz.agenda.inteligente.database.entities.Category;
import dev.rvz.agenda.inteligente.database.exceptions.categories.CategoryAlreadyExistsWithNameException;
import dev.rvz.agenda.inteligente.database.repositories.CategoryRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.categories.CreateCategoryServiceable;
import dev.rvz.agenda.inteligente.database.services.contracts.categories.ExistsCategoryByNameServiceable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService implements CreateCategoryServiceable {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateCategoryService.class);
	private final CategoryRepository categoryRepository;
	private final ExistsCategoryByNameServiceable existsCategoryByNameService;

	public CreateCategoryService(CategoryRepository categoryRepository,
			ExistsCategoryByNameServiceable existsCategoryByNameService) {
		this.categoryRepository = categoryRepository;
		this.existsCategoryByNameService = existsCategoryByNameService;
	}

	public Iterable<Category> getAll() {
		return this.categoryRepository.findAll();
	}

	@Override
	public Category execute(Category category) {
		LOGGER.info("create - category: {}", category);
		existsCategoryWithName(category);

		return this.categoryRepository.save(category);
	}

	private void existsCategoryWithName(Category category) {
		if (this.existsCategoryByNameService.execute(category.getName())) {
			LOGGER.error("execute - category with name " + category.getName() + " already exists!");
			throw new CategoryAlreadyExistsWithNameException(
					"a categoria com nome " + category.getName() + " ja existe!");
		}
	}
}
