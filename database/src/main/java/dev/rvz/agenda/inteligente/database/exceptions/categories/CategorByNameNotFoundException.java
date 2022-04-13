package dev.rvz.agenda.inteligente.database.exceptions.categories;

public class CategorByNameNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2354382098793776375L;
	private final Integer code = 400;

	public CategorByNameNotFoundException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}
}
