package br.com.agenda_inteligente.agenda_inteligente_database.entities;

import java.time.LocalDate;

import br.com.agenda_inteligente.agenda_inteligente_database.helpers.EntityToString;

public class Profile {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
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

    public LocalDate getBirthdate() {
	return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
	this.birthdate = birthdate;
    }

    public Contact getContact() {
	return contact;
    }

    public void setContact(Contact contact) {
	this.contact = contact;
    }

    @Override
    public String toString() {
	return EntityToString.generate(this);
    }
}
