package dev.rvz.agenda.inteligente.webservice.exceptions.categories;

public class CreateCategoryInternalServerErrorException extends RuntimeException {
	private Integer code = 500;

	public CreateCategoryInternalServerErrorException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
