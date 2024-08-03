package com.hueged.hashedin.Order.Service.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(NoOrderFoundException.class)
	public ResponseEntity<ExceptionalMessage> noOrderFoundException(NoOrderFoundException noOrderFoundException){
		String errMsg = noOrderFoundException.getMessage();
		return new ResponseEntity<ExceptionalMessage>(new ExceptionalMessage(errMsg, LocalDateTime.now(), false),
				HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(PastDateException.class)
	public ResponseEntity<ExceptionalMessage> PastDateException(PastDateException noOrderFoundException){
		String errMsg = noOrderFoundException.getMessage();
		return new ResponseEntity<ExceptionalMessage>(new ExceptionalMessage(errMsg, LocalDateTime.now(), false),
				HttpStatus.NOT_FOUND);
	}
}
