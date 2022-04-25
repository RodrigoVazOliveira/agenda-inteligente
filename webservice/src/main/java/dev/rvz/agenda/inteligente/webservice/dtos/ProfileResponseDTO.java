package dev.rvz.agenda.inteligente.webservice.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import dev.rvz.agenda.inteligente.webservice.helpers.ConvertObjectToJson;

public class ProfileResponseDTO {

	private final Long id;
	private final String firstName;
	private final String lastName;

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
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
