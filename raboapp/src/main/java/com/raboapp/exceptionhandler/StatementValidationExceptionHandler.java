package com.raboapp.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.raboapp.bean.ErrorResponse;
import com.raboapp.exception.InputParseException;
import com.raboapp.exception.UnSupportedMediaTypeException;

@ControllerAdvice
public class StatementValidationExceptionHandler {
	
	@ExceptionHandler(InputParseException.class)
	public ResponseEntity<ErrorResponse> handleInputParseError(InputParseException ex){
		ErrorResponse errResponse = new ErrorResponse();
		errResponse.setErrorCode(ex.getErrorCode());
		errResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
		errResponse.setErrorMessage(ex.getMessage());
		
		return new ResponseEntity<>(errResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnSupportedMediaTypeException.class)
	public ResponseEntity<ErrorResponse> handleInputParseError(UnSupportedMediaTypeException ex){
		ErrorResponse errResponse = new ErrorResponse();
		errResponse.setErrorCode(ex.getErrorCode());
		errResponse.setStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE.name());
		errResponse.setErrorMessage(ex.getMessage());
		
		return new ResponseEntity<>(errResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
}
