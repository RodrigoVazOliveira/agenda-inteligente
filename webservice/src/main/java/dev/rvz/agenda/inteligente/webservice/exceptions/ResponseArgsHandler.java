package dev.rvz.agenda.inteligente.webservice.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
class ResponseArgsHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<InputErrorRequest> inputErrorRequests = this.getFieldsErrors(ex.getFieldErrors());
		ResponseErrorArgument responseErrorArgument = new ResponseErrorArgument(inputErrorRequests);

		return ResponseEntity.status(status).headers(headers).body(responseErrorArgument);
	}

	private List<InputErrorRequest> getFieldsErrors(List<FieldError> fieldErrors) {
		return fieldErrors.stream()
				.map(fieldError -> new InputErrorRequest(fieldError.getField(), fieldError.getDefaultMessage()))
				.collect(Collectors.toList());
	}

}