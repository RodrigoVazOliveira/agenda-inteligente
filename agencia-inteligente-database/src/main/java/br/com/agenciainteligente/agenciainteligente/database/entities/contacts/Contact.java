package br.com.agenciainteligente.agenciainteligente.database.entities.contacts;

import br.com.agenciainteligente.agenciainteligente.database.helpers.DeserializeToString;

import java.util.List;

public class Contact {
    private final Email email;
    private final List<Telephone> telephones;

    public Contact(Email email, List<Telephone> telephones) {
        this.email = email;
        this.telephones = telephones;
    }

    @Override
    public String toString() {
        return DeserializeToString.getString(this);
    }
}