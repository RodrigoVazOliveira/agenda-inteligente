package dev.rvz.agenda.inteligente.webservice.exceptions;

public class CreateCategoryBadRequestException extends RuntimeException {

	private Integer code = 400;

	public CreateCategoryBadRequestException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
