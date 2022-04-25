package dev.rvz.agenda.inteligente.database.exceptions.categories;

public class CategoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5216303659047495402L;
	private final Integer code = 400;

	public CategoryNotFoundException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
