package dev.rvz.agenda.inteligente.database.exceptions.diaries;

import dev.rvz.agenda.inteligente.database.exceptions.TemplateNotArgumentsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class DiaryRestControllerAdviceHandler {

	@ExceptionHandler({ DiaryByIdNotFoundException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	TemplateNotArgumentsException diaryByIdNotFoundException(DiaryByIdNotFoundException exception) {
		return new TemplateNotArgumentsException(exception.getCode(), exception.getMessage());
	}
}
