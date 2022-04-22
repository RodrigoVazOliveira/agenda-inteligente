package dev.rvz.agenda.inteligente.webservice.dtos;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class CreateProfileRequestDTO {

	@NotBlank(message = "o firstname deve ser preenchido")
	@Size(min = 3, max = 70, message = "deve possuir no minio 3 e no maximo 70 caracteres")
	private final String firstName;

	@NotBlank(message = "o lastName deve ser preenchido")
	@Size(min = 3, max = 70, message = "deve possuir no minio 3 e no maximo 70 caracteres")
	private final String lastName;

	@NotBlank(message = "o birthdate deve ser preenchido")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private final LocalDate birthdate;

	@NotBlank(message = "o email deve ser preenchido")
	@Email(message = "o email informado nao e valido")
	private final String email;

	@JsonProperty("telephones")
	private final List<TelephoneDTO> telephoneDTOs;

	public CreateProfileRequestDTO(
			@NotBlank(message = "o firstname deve ser preenchido") @Size(min = 3, max = 70, message = "deve possuir no minio 3 e no maximo 70 caracteres") String firstName,
			@NotBlank(message = "o lastName deve ser preenchido") @Size(min = 3, max = 70, message = "deve possuir no minio 3 e no maximo 70 caracteres") String lastName,
			@NotBlank(message = "o birthdate deve ser preenchido") LocalDate birthdate,
			@NotBlank(message = "o email deve ser preenchido") @Email(message = "o email informado nao e valido") String email,
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
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}
}
