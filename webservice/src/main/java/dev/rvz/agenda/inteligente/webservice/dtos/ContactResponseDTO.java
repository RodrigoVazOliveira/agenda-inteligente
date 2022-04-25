package dev.rvz.agenda.inteligente.webservice.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.rvz.agenda.inteligente.webservice.helpers.ConvertObjectToJson;

public class ContactResponseDTO {

	private final Email email;
	private final List<Telephone> telephones;

	@JsonCreator
	public ContactResponseDTO(@JsonProperty("email") Email email,
			@JsonProperty("telephones") List<Telephone> telephones) {
		this.email = email;
		this.telephones = telephones;
	}

	public Email getEmail() {
		return email;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	@Override
	public String toString() {
		return ConvertObjectToJson.run(this);
	}
}
