package dev.rvz.agenda.inteligente.database.exceptions;

public class DiaryByIdNotFoundException extends RuntimeException {

	private final Integer code = 400;

	public DiaryByIdNotFoundException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
