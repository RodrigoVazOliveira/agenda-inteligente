package dev.rvz.agenda.inteligente.database.exceptions.profiles;

import dev.rvz.agenda.inteligente.database.exceptions.TemplateNotArgumentsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ProfileRestControllerAdviceHandler {

	@ExceptionHandler({ ProfileNotFoundException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	TemplateNotArgumentsException pofileNotFoundException(ProfileNotFoundException exception) {
		return new TemplateNotArgumentsException(exception.getCode(), exception.getMessage());
	}

	@ExceptionHandler({ ProfileWithEmailAlreadyException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	TemplateNotArgumentsException profileWithEmailAlreadyException(ProfileWithEmailAlreadyException exception) {
		return new TemplateNotArgumentsException(exception.getCode(), exception.getMessage());
	}
}
