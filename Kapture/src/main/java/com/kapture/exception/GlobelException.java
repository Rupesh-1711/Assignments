package com.kapture.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelException {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> Exception(Exception e,WebRequest req) {
		
		MyErrorDetail err = new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CallDataException.class)
	public ResponseEntity<MyErrorDetail> CallDataException(CallDataException e,WebRequest req) {
		
		MyErrorDetail err = new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
}
