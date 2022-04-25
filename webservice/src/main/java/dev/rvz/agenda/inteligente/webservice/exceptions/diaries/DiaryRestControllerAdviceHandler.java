package dev.rvz.agenda.inteligente.webservice.exceptions.diaries;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.rvz.agenda.inteligente.webservice.exceptions.ResponseNotArgsValidation;

@RestControllerAdvice
class DiaryRestControllerAdviceHandler {

	@ExceptionHandler(value = DiaryBadRequestException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	ResponseNotArgsValidation diaryBadRequestException(DiaryBadRequestException exception) {
		return new ResponseNotArgsValidation(exception.getCode(), exception.getMessage());
	}

	@ExceptionHandler(value = DiaryInternalServerErrorException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	ResponseNotArgsValidation diaryInternalServerErrorException(DiaryInternalServerErrorException exception) {
		return new ResponseNotArgsValidation(exception.getCode(), exception.getMessage());
	}
}
