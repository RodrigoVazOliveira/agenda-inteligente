package dev.rvz.agenda.inteligente.database.exceptions;

public class CategorByNameNotFoundException extends RuntimeException {

	private final Integer code = 400;

	public CategorByNameNotFoundException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
