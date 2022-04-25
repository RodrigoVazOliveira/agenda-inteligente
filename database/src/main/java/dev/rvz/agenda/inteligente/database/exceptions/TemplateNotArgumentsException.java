package dev.rvz.agenda.inteligente.database.exceptions;

public class TemplateNotArgumentsException {

	private final Integer code;
	private final String message;

	public TemplateNotArgumentsException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
