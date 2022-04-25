package dev.rvz.agenda.inteligente.webservice.exceptions.profiles;

public class CreateProfileInternalErrorException extends RuntimeException {

	private final Integer code = 500;

	public CreateProfileInternalErrorException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
