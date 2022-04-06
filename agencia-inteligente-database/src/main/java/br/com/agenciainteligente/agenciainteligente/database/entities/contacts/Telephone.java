package br.com.agenciainteligente.agenciainteligente.database.entities.contacts;

import br.com.agenciainteligente.agenciainteligente.database.helpers.DeserializeToString;

import javax.persistence.Embeddable;

@Embeddable
public class Telephone {

    private Integer ddd;
    private Integer number;

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return DeserializeToString.getString(this);
    }
}