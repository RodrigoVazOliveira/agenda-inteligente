package br.com.agenciainteligente.agenciainteligente.database.entities.contacts;

import br.com.agenciainteligente.agenciainteligente.database.helpers.DeserializeToString;

public class Email {
    private final String address;

    public Email(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return DeserializeToString.getString(this);
    }
}
