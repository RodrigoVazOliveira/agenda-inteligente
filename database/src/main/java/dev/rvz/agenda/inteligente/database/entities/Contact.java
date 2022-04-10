package dev.rvz.agenda.inteligente.database.entities;

import java.util.List;

import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

public class Contact {

	private Email email;
	private List<Telephone> telephones;

	public Contact() {
	}

	public Contact(Email email, List<Telephone> telephones) {
		this.email = email;
		this.telephones = telephones;
	}

	public Email getEmail() {
		return email;
	}
`
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
