package dev.rvz.agenda.inteligente.database.entities;

import java.time.LocalDateTime;

import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

public class Diary {

	private Long id;
	private Profile profile;
	private LocalDateTime dateTime;
	private String subject;
	private String description;
	private String comments;
	private TypePlaceEnum place;
	private Category category;

	public Diary() {
	}

	public Diary(Long id, Profile profile, LocalDateTime dateTime, String subject, String description, String comments,
			TypePlaceEnum place, Category category) {
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

	public void setId(Long id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public TypePlaceEnum getPlace() {
		return place;
	}

	public void setPlace(TypePlaceEnum place) {
		this.place = place;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return ConvertEntityToString.run(this);
	}
}
