package dev.rvz.agenda.inteligente.database.entities;

import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

import javax.persistence.Embeddable;

@Embeddable
public class Telephone {

	private Integer ddd;
	private Integer number;

	public Telephone() {
	}

	public Telephone(Integer ddd, Integer number) {
		this.ddd = ddd;
		this.number = number;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return ConvertEntityToString.run(this);
	}
}
