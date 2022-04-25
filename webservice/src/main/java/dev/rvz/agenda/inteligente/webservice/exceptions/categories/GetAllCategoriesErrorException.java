package dev.rvz.agenda.inteligente.webservice.exceptions.categories;

public class GetAllCategoriesErrorException extends RuntimeException {

	private final Integer code = 500;

	public GetAllCategoriesErrorException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}

}
