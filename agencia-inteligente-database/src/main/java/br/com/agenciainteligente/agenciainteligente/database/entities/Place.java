package br.com.agenciainteligente.agenciainteligente.database.entities;

import br.com.agenciainteligente.agenciainteligente.database.helpers.DeserializeToString;

public class Place {
    private final TypePlaceEnum type;
    private final String address;

    public Place(TypePlaceEnum type, String address) {
        this.type = type;
        this.address = address;
    }

    @Override
    public String toString() {
       return DeserializeToString.getString(this);
    }
}
