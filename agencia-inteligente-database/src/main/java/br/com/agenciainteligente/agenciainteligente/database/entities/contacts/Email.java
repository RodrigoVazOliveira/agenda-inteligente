package br.com.agenciainteligente.agenciainteligente.database.entities.contacts;

import br.com.agenciainteligente.agenciainteligente.database.helpers.DeserializeToString;

import javax.persistence.Embeddable;

@Embeddable
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
        return DeserializeToString.getString(this);
    }
}