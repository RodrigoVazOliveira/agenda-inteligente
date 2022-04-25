package dev.rvz.agenda.inteligente.database.controllers.contract;

import org.springframework.web.bind.annotation.RequestBody;

import dev.rvz.agenda.inteligente.database.dtos.CreateCategoryDTO;
import dev.rvz.agenda.inteligente.database.entities.Category;

public interface CategoryRestControllerable {
	Category create(@RequestBody CreateCategoryDTO createCategoryDTO);

	Iterable<Category> getAll();
}
