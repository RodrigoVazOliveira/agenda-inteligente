package dev.rvz.agenda.inteligente.database.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;

import dev.rvz.agenda.inteligente.database.entities.Category;
import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

public class CreateCategoryDTO {

	private final String name;

	@JsonCreator
	public CreateCategoryDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return ConvertEntityToString.run(this);
	}

	public Category convertDTOToEntityCategory() {
		Category category = new Category();
		category.setName(this.name);

		return category;
	}
}
