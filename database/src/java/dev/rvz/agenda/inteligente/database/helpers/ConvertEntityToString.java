package dev.rvz.agenda.inteligente.database.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertEntityToString {

	public static String run(Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}
}