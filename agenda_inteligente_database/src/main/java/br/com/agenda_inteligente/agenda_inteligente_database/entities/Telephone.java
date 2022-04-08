package br.com.agenda_inteligente.agenda_inteligente_database.entities;

import br.com.agenda_inteligente.agenda_inteligente_database.helpers.EntityToString;

public class Telephone {

	private Integer ddd;
	private Integer number;

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
		return EntityToString.generate(this);
	}

}
