package com.vip.rating.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Object> handleGlobalExceptions(HttpRequestMethodNotSupportedException ex){
		Map<String, Object> response = new HashMap<>();
		
		response.put("message", ex.getMessage());
		response.put("status",HttpStatus.BAD_REQUEST);
		response.put("success", false);
		
		return ResponseEntity.ok(response);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleGlobalExceptions(Exception ex){
		Map<String, Object> response = new HashMap<>();
		
		response.put("message", ex.getMessage());
		response.put("status",HttpStatus.INTERNAL_SERVER_ERROR);
		response.put("success", false);
		
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
