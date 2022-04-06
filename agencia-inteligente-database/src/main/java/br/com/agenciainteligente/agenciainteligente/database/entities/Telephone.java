package br.com.agenciainteligente.agenciainteligente.database.entities;

import br.com.agenciainteligente.agenciainteligente.database.helpers.DeserializeToString;

public class Telephone {

    private final Integer ddd;
    private final Integer number;

    public Telephone(Integer ddd, Integer number) {
        this.ddd = ddd;
        this.number = number;
    }

    @Override
    public String toString() {
        return DeserializeToString.getString(this);
    }
}