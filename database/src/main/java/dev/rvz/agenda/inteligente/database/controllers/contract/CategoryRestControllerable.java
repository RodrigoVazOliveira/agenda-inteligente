package dev.rvz.agenda.inteligente.database.controllers.contract;

import dev.rvz.agenda.inteligente.database.dtos.CreateCategoryDTO;
import dev.rvz.agenda.inteligente.database.entities.Category;
import org.springframework.web.bind.annotation.RequestBody;

public interface CategoryRestControllerable {
	Category create(@RequestBody CreateCategoryDTO createCategoryDTO);

	Iterable<Category> getAll();
}
