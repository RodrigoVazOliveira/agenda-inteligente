package br.com.agenda_inteligente.agenda_inteligente_database.entities;

import br.com.agenda_inteligente.agenda_inteligente_database.helpers.EntityToString;

public class Place {

    private TypePlaceEnum type;
    private String address;

    public TypePlaceEnum getType() {
	return type;
    }

    public void setType(TypePlaceEnum type) {
	this.type = type;
    }

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
