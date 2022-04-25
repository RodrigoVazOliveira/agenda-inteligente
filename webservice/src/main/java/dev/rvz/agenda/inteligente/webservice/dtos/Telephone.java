package dev.rvz.agenda.inteligente.webservice.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.rvz.agenda.inteligente.webservice.helpers.ConvertObjectToJson;

public class Telephone {

	private final Integer ddd;
	private final Integer number;

	@JsonCreator
	public Telephone(@JsonProperty("ddd") Integer ddd, @JsonProperty("number") Integer number) {
		this.ddd = ddd;
		this.number = number;
	}

	public Integer getDdd() {
		return ddd;
	}

	public Integer getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return ConvertObjectToJson.run(this);
	}
}
