package br.com.agenciainteligente.agenciainteligente.database.entities;

import br.com.agenciainteligente.agenciainteligente.database.helpers.DeserializeToString;

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
       return DeserializeToString.getString(this);
    }
}
