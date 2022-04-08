package br.com.agenda_inteligente.agenda_inteligente_database.entities;

import br.com.agenda_inteligente.agenda_inteligente_database.helpers.EntityToString;

public class Email {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return EntityToString.generate(this);
	}

}
