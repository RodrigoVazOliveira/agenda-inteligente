package dev.rvz.agenda.inteligente.webservice.exceptions.profiles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.rvz.agenda.inteligente.webservice.exceptions.ResponseNotArgsValidation;

@RestControllerAdvice
class ProfileRestControllerAdviceHandler {

	@ExceptionHandler(value = CreateProfileBadRequestException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	ResponseNotArgsValidation createProfileBadRequestException(CreateProfileBadRequestException exception) {
		return new ResponseNotArgsValidation(exception.getCode(), exception.getMessage());
	}

	@ExceptionHandler(value = CreateProfileInternalErrorException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	ResponseNotArgsValidation createProfileInternalErrorException(CreateProfileInternalErrorException exception) {
		return new ResponseNotArgsValidation(exception.getCode(), exception.getMessage());
	}

	@ExceptionHandler(value = GetAllProfileInternalServerErrorException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	ResponseNotArgsValidation getAllProfileInternalServerErrorException(
			GetAllProfileInternalServerErrorException exception) {
		return new ResponseNotArgsValidation(exception.getCode(), exception.getMessage());
	}
}
