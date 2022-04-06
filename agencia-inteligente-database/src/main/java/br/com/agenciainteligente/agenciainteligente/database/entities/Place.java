package br.com.agenciainteligente.agenciainteligente.database.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Place {
    private final TypePlaceEnum type;
    private final String address;

    public Place(TypePlaceEnum type, String address) {
        this.type = type;
        this.address = address;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
