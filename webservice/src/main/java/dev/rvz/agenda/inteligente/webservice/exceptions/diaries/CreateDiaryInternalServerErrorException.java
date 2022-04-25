package dev.rvz.agenda.inteligente.webservice.exceptions.diaries;

public class CreateDiaryInternalServerErrorException extends RuntimeException {

	private final Integer code = 500;

	public CreateDiaryInternalServerErrorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public Integer getCode() {
		return code;
	}
}
