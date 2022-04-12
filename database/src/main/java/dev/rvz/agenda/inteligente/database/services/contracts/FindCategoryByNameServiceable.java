package dev.rvz.agenda.inteligente.database.services.contracts;

import dev.rvz.agenda.inteligente.database.entities.Category;

public interface FindCategoryByNameServiceable {
	Category execute(String name);
}
