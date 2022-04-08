package br.com.agenda_inteligente.agenda_inteligente_database.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

import br.com.agenda_inteligente.agenda_inteligente_database.helpers.EntityToString;

@Embeddable
public class Contact {

    private Email email;
    @ElementCollection
    private List<Telephone> telephones;

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
	return EntityToString.generate(this);
    }
}
