package dev.rvz.agenda.inteligente.webservice.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.rvz.agenda.inteligente.webservice.helpers.ConvertObjectToJson;

public class CreateDiaryRequestDTO {

	@NotBlank(message = "email nao foi preenchido")
	@Email(message = "email nao e valido")
	private final String email;

	@NotBlank(message = "subject nao foi preenchido")
	private final String subject;

	@NotBlank(message = "description nao foi preenchido")
	private final String description;

	@NotBlank(message = "comments nao foi preenchido")
	private final String comments;

	@NotBlank(message = "place nao foi preenchido")
	private final String place;

	@NotBlank(message = "category nao foi preenchido")
	private final String category;

	@JsonCreator
	public CreateDiaryRequestDTO(
			@NotBlank(message = "email nao foi preenchido") @Email(message = "email nao e valido") @JsonProperty("email") String email,
			@NotBlank(message = "subject nao foi preenchido") @JsonProperty("subject") String subject,
			@NotBlank(message = "description nao foi preenchido") @JsonProperty("description") String description,
			@NotBlank(message = "comments nao foi preenchido") @JsonProperty("comments") String comments,
			@NotBlank(message = "email nao foi preenchido") @JsonProperty("place") String place,
			@NotBlank(message = "category nao foi preenchido") @JsonProperty("category") String category) {
		this.email = email;
		this.subject = subject;
		this.description = description;
		this.comments = comments;
		this.place = place;
		this.category = category;
	}

	public String getEmail() {
		return email;
	}

	public String getSubject() {
		return subject;
	}

	public String getDescription() {
		return description;
	}

	public String getComments() {
		return comments;
	}

	public String getPlace() {
		return place;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return ConvertObjectToJson.run(this);
	}
}
