package dev.rvz.agenda.inteligente.database.exceptions.categories;

import dev.rvz.agenda.inteligente.database.exceptions.TemplateNotArgumentsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class CategoryRestControllerAdviceHandler {

	@ExceptionHandler({ CategorByNameNotFoundException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	TemplateNotArgumentsException categorByNameNotFoundException(CategorByNameNotFoundException exception) {
		return new TemplateNotArgumentsException(exception.getCode(), exception.getMessage());
	}

	@ExceptionHandler({ CategoryAlreadyExistsWithNameException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	TemplateNotArgumentsException categoryAlreadyExistsWithNameException(
			CategoryAlreadyExistsWithNameException exception) {
		return new TemplateNotArgumentsException(exception.getCode(), exception.getMessage());
	}

	@ExceptionHandler({ CategoryNotFoundException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	TemplateNotArgumentsException categoryNotFoundException(CategoryNotFoundException exception) {
		return new TemplateNotArgumentsException(exception.getCode(), exception.getMessage());
	}
}
