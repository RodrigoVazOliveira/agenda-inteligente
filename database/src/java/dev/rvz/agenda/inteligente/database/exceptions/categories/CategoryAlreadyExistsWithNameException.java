package dev.rvz.agenda.inteligente.database.exceptions.categories;

public class CategoryAlreadyExistsWithNameException extends RuntimeException {

	private static final long serialVersionUID = -9071231968169517908L;
	private final Integer code = 400;

	public CategoryAlreadyExistsWithNameException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
