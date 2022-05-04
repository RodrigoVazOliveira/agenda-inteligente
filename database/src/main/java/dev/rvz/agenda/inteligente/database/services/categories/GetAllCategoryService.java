package dev.rvz.agenda.inteligente.database.services.categories;

import dev.rvz.agenda.inteligente.database.entities.Category;
import dev.rvz.agenda.inteligente.database.repositories.CategoryRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.categories.GetAllCategoryServiceable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetAllCategoryService implements GetAllCategoryServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(GetAllCategoryService.class);
	private final CategoryRepository categoryRepository;

	public GetAllCategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Iterable<Category> execute() {
		Iterable<Category> categories = this.categoryRepository.findAll();
		LOGGER.info("execute output categories: {}", categories);

		return categories;
	}

}
