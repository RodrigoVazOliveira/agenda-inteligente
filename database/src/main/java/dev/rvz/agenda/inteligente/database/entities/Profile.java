package dev.rvz.agenda.inteligente.database.entities;

import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

import javax.persistence.*;
import java.time.LocalDate;

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
