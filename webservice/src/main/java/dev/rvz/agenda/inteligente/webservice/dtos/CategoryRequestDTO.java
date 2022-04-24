package dev.rvz.agenda.inteligente.webservice.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.rvz.agenda.inteligente.webservice.helpers.ConvertObjectToJson;

public class CategoryRequestDTO {

	@NotBlank(message = "campo name deve ser preenchido!")
	@Max(value = 50, message = "o limite maximo e de 50 caracteres")
	private final String name;

	@JsonCreator
	public CategoryRequestDTO(@JsonProperty("name") String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return ConvertObjectToJson.run(this);
	}
}
