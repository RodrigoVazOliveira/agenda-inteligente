package dev.rvz.agenda.inteligente.webservice.exceptions.categories;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.rvz.agenda.inteligente.webservice.exceptions.ResponseNotArgsValidation;

@RestControllerAdvice
class CategoryRestAdviceHandler {

	@ExceptionHandler(CreateCategoryBadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseNotArgsValidation createCategoryBadRequestException(CreateCategoryBadRequestException e) {
		return new ResponseNotArgsValidation(e.getCode(), e.getMessage());
	}
}
