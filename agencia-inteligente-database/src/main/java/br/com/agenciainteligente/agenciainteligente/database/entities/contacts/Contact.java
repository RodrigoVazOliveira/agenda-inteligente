package br.com.agenciainteligente.agenciainteligente.database.entities.contacts;

import br.com.agenciainteligente.agenciainteligente.database.helpers.DeserializeToString;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.List;

@Embeddable
public class Contact {

    @Embedded
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
        return DeserializeToString.getString(this);
    }
}