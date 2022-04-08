package br.com.agenda_inteligente.agenda_inteligente_database.entities;

import br.com.agenda_inteligente.agenda_inteligente_database.helpers.EntityToString;

public class Email {

    private String address;

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    @Override
    public String toString() {
	return EntityToString.generate(this);
    }
}
