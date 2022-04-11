package dev.rvz.agenda.inteligente.database.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

@Entity
@Table(name = "profiles")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 70, nullable = false, name = "first_name")
	private String firstName;

	@Column(length = 70, nullable = false, name = "last_name")
	private String lastName;
	private LocalDate bithdate;

	@Embedded
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
