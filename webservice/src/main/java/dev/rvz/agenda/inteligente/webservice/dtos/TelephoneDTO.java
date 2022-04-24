package dev.rvz.agenda.inteligente.webservice.dtos;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.rvz.agenda.inteligente.webservice.helpers.ConvertObjectToJson;

public class TelephoneDTO {

	@NotNull
	private final Integer ddd;

	@NotNull
	private final Integer telephone;

	@JsonCreator
	public TelephoneDTO(@JsonProperty("ddd") Integer ddd, @JsonProperty("telephone") Integer telephone) {
		this.ddd = ddd;
		this.telephone = telephone;
	}

	public Integer getDdd() {
		return ddd;
	}

	public Integer getTelephone() {
		return telephone;
	}

	@Override
	public String toString() {
		return ConvertObjectToJson.run(this);
	}
}
