package dev.rvz.agenda.inteligente.webservice.exceptions.profiles;

public class GetAllProfileInternalServerErrorException extends RuntimeException {

	private final Integer code = 500;

	public GetAllProfileInternalServerErrorException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
