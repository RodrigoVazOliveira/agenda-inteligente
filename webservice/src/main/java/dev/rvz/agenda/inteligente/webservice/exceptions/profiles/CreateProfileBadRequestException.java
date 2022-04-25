package dev.rvz.agenda.inteligente.webservice.exceptions.profiles;

public class CreateProfileBadRequestException extends RuntimeException {

	private final Integer code = 400;

	public CreateProfileBadRequestException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
