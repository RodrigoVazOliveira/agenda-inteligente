package dev.rvz.agenda.inteligente.webservice.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.rvz.agenda.inteligente.webservice.helpers.ConvertObjectToJson;

public class ProfileResponseDTO {

	private final Long id;
	private final String firstName;
	private final String lastName;

	private final LocalDate bithdate;
	private final ContactResponseDTO contact;

	@JsonCreator
	public ProfileResponseDTO(@JsonProperty("id") Long id, @JsonProperty("firstName") String firstName,
			@JsonProperty("lastName") String lastName, @JsonProperty("bithdate") LocalDate bithdate,
			@JsonProperty("contact") ContactResponseDTO contact) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bithdate = bithdate;
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBithdate() {
		return bithdate;
	}

	public ContactResponseDTO getContact() {
		return contact;
	}

	@Override
	public String toString() {
		return ConvertObjectToJson.run(this);
	}
}
