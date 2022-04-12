package dev.rvz.agenda.inteligente.database.exceptions;

public class ProfileNotFoundException extends RuntimeException {

	private final Integer code = 400;

	public ProfileNotFoundException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}

}
