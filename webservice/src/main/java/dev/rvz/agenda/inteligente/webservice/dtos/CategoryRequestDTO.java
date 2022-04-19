package dev.rvz.agenda.inteligente.webservice.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
