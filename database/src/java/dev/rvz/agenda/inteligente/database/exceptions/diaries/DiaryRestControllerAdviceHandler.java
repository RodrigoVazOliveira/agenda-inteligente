package dev.rvz.agenda.inteligente.database.exceptions.diaries;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.rvz.agenda.inteligente.database.exceptions.TemplateNotArgumentsException;

@RestControllerAdvice
class DiaryRestControllerAdviceHandler {

	@ExceptionHandler({ DiaryByIdNotFoundException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	TemplateNotArgumentsException diaryByIdNotFoundException(DiaryByIdNotFoundException exception) {
		return new TemplateNotArgumentsException(exception.getCode(), exception.getMessage());
	}
}
