package dev.rvz.agenda.inteligente.webservice.exceptions.diaries;

public class DiaryBadRequestException extends RuntimeException {

	private final Integer code = 400;

	public DiaryBadRequestException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
