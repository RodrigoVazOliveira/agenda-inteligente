package dev.rvz.agenda.inteligente.database.entities;

import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

import javax.persistence.Embeddable;

@Embeddable
public class Email {

	private String address;

	public Email() {
	}

	public Email(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return ConvertEntityToString.run(this);
	}
}
