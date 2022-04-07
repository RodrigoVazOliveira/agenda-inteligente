package br.com.agenda_inteligente.agenda_inteligente_database.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EntityToString {

    public static String generate(Object object) {
	ObjectMapper objectMapper = new ObjectMapper();
	try {
	    return objectMapper.writeValueAsString(object);
	} catch (JsonProcessingException exception) {
	    throw new RuntimeException(exception.getMessage());
	}
    }
}
