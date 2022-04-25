package dev.rvz.agenda.inteligente.webservice.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.rvz.agenda.inteligente.webservice.helpers.ConvertObjectToJson;

public class Email {

	private final String address;

	@JsonCreator
	public Email(@JsonProperty("address") String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return ConvertObjectToJson.run(this);
	}
}
