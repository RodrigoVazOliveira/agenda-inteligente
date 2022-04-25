package dev.rvz.agenda.inteligente.webservice.exceptions;

import java.util.List;

public class ResponseErrorArgument {

	private final String cause = "VALIDATION";
	private final Integer status = 400;
	private final List<InputErrorRequest> inputs;

	public ResponseErrorArgument(List<InputErrorRequest> inputs) {
		this.inputs = inputs;
	}

	public String getCause() {
		return cause;
	}

	public Integer getStatus() {
		return status;
	}

	public List<InputErrorRequest> getInputs() {
		return inputs;
	}

}
