package dev.rvz.agenda.inteligente.webservice.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import dev.rvz.agenda.inteligente.webservice.helpers.ConvertObjectToJson;

public class DiaryResponseDTO {

	private final Long id;
	private final ProfileResponseDTO profile;

	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private final LocalDateTime dateTime;
	private final String subject;
	private final String description;
	private final String comments;
	private final TypePlaceEnum place;
	private final CategoryResponseDTO category;

	@JsonCreator
	public DiaryResponseDTO(@JsonProperty("id") Long id, @JsonProperty("profile") ProfileResponseDTO profile,
			@JsonProperty("dateTime") LocalDateTime dateTime, @JsonProperty("subject") String subject,
			@JsonProperty("description") String description, @JsonProperty("comments") String comments,
			@JsonProperty("place") TypePlaceEnum place, @JsonProperty("category") CategoryResponseDTO category) {
		this.id = id;
		this.profile = profile;
		this.dateTime = dateTime;
		this.subject = subject;
		this.description = description;
		this.comments = comments;
		this.place = place;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public ProfileResponseDTO getProfile() {
		return profile;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
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

	public TypePlaceEnum getPlace() {
		return place;
	}

	public CategoryResponseDTO getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return ConvertObjectToJson.run(this);
	}
}
