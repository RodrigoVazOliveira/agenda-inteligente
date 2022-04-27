package dev.rvz.agenda.inteligente.database.services.categories;

import dev.rvz.agenda.inteligente.database.repositories.CategoryRepository;
import dev.rvz.agenda.inteligente.database.services.contracts.categories.ExistsCategoryByNameServiceable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExistsCategoryByNameService implements ExistsCategoryByNameServiceable {
	private final static Logger LOGGER = LoggerFactory.getLogger(ExistsCategoryByNameService.class);
	private final CategoryRepository categoryRepository;

	public ExistsCategoryByNameService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Boolean execute(String name) {
		LOGGER.info("execute input name: {}", name);
		Boolean exists = this.categoryRepository.existsByName(name);
		LOGGER.info("execute output exists: {}", exists);

		return exists;
	}

}
