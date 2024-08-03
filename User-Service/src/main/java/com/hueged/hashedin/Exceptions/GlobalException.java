package com.hueged.hashedin.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserAlreadyPresentException.class)
	public ResponseEntity<ExceptionalMessage> userAlreadyPresentException(UserAlreadyPresentException userAlreadyPresentException ){
		String errMsg = userAlreadyPresentException.getMessage();
		return new ResponseEntity<ExceptionalMessage>(new ExceptionalMessage(errMsg, LocalDateTime.now(), false),
				HttpStatus.BAD_REQUEST);
	}
	
	
	
}
