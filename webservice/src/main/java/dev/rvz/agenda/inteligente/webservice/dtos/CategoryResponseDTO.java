package dev.rvz.agenda.inteligente.webservice.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.rvz.agenda.inteligente.webservice.helpers.ConvertObjectToJson;

public class CategoryResponseDTO {

	private final Long id;
	private final String name;

	@JsonCreator
	public CategoryResponseDTO(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return ConvertObjectToJson.run(this);
	}
}
