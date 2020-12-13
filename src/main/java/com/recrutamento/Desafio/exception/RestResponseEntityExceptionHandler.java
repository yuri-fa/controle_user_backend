package com.recrutamento.Desafio.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<StandartError> userExistException(UserExistException exception,HttpServletRequest http){
		HttpStatus status = HttpStatus.CONFLICT;
		StandartError error = new StandartError(System.currentTimeMillis(),status.ordinal(),"UserExist",exception.getMessage(),http.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<StandartError> userNotFound(UserNotFoundException exception,HttpServletRequest http){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError error = new StandartError(System.currentTimeMillis(),status.ordinal(),"UserExist",exception.getMessage(),http.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(UserDataNotFound.class)
	public ResponseEntity<StandartError> userDataNotFoun(UserDataNotFound exception,HttpServletRequest http){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError error = new StandartError(System.currentTimeMillis(),status.ordinal(),"UserDataNotFoun",exception.getMessage(),http.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
}
