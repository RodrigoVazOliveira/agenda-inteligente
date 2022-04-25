package dev.rvz.agenda.inteligente.webservice.exceptions.diaries;

public class CreateDiaryBadRequestException extends RuntimeException {

	private final Integer code = 400;

	public CreateDiaryBadRequestException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
