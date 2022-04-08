package br.com.agenda_inteligente.agenda_inteligente_database.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import br.com.agenda_inteligente.agenda_inteligente_database.helpers.EntityToString;

@Entity
@Table(name = "profiles", indexes = @Index(columnList = "firstName"))
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 70)
    private String firstName;

    @Column(nullable = false, length = 70)
    private String lastName;
    private LocalDate birthdate;

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
