package dev.rvz.agenda.inteligente.database.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;

import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

public class TelephoneDTO {

	private final Integer ddd;
	private final Integer telephone;

	@JsonCreator
	public TelephoneDTO(Integer ddd, Integer telephone) {
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
		return ConvertEntityToString.run(this);
	}
}
