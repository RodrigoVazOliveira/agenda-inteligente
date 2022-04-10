package dev.rvz.agenda.inteligente.database.entities;

import java.time.LocalDate;

import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

public class Profile {

	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate bithdate;
	private Contact contact;

	public Profile() {
	}

	public Profile(Long id, String firstName, String lastName, LocalDate bithdate, Contact contact) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bithdate = bithdate;
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBithdate() {
		return bithdate;
	}

	public void setBithdate(LocalDate bithdate) {
		this.bithdate = bithdate;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return ConvertEntityToString.run(this);
	}
}
