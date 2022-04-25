package dev.rvz.agenda.inteligente.database.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import dev.rvz.agenda.inteligente.database.entities.Contact;
import dev.rvz.agenda.inteligente.database.entities.Email;
import dev.rvz.agenda.inteligente.database.entities.Profile;
import dev.rvz.agenda.inteligente.database.entities.Telephone;
import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

public class CreateProfileDTO {

	private final String firstName;
	private final String lastName;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private final LocalDate birthdate;
	private final String email;

	@JsonProperty("telephones")
	private final List<TelephoneDTO> telephoneDTOs;

	@JsonCreator
	public CreateProfileDTO(String firstName, String lastName, LocalDate birthdate, String email,
			List<TelephoneDTO> telephoneDTOs) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.email = email;
		this.telephoneDTOs = telephoneDTOs;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public String getEmail() {
		return email;
	}

	public List<TelephoneDTO> getTelephoneDTOs() {
		return telephoneDTOs;
	}

	@Override
	public String toString() {
		return ConvertEntityToString.run(this);
	}

	public Profile convertDTOToEntityProfile() {
		Email email = new Email(this.email);
		List<Telephone> telephones = convertTelephonesDTOsToEntityTelephone();
		Contact contact = new Contact(email, telephones);

		Profile profile = new Profile();
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profile.setBithdate(birthdate);
		profile.setContact(contact);

		return profile;
	}

	private List<Telephone> convertTelephonesDTOsToEntityTelephone() {
		List<Telephone> telephones = new ArrayList<Telephone>();

		this.telephoneDTOs.forEach(telephoneDTO -> {
			Telephone telephone = new Telephone(telephoneDTO.getDdd(), telephoneDTO.getTelephone());
			telephones.add(telephone);
		});

		return telephones;
	}
}
