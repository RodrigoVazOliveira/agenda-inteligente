package dev.rvz.agenda.inteligente.webservice.exceptions;

public class InputErrorRequest {

	private final String input;
	private final String message;

	public InputErrorRequest(String input, String message) {
		this.input = input;
		this.message = message;
	}

	public String getInput() {
		return input;
	}

	public String getMessage() {
		return message;
	}

}
