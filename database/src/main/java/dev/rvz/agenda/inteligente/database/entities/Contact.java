package dev.rvz.agenda.inteligente.database.entities;

import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Contact {

	@Embedded
	private Email email;

	@ElementCollection
	private List<Telephone> telephones = new ArrayList<Telephone>();

	public Contact() {
	}

	public Contact(Email email, List<Telephone> telephones) {
		this.email = email;
		this.telephones = telephones;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	@Override
	public String toString() {
		return ConvertEntityToString.run(this);
	}
}
