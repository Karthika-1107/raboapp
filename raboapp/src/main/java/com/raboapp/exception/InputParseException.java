package com.raboapp.exception;

public class InputParseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String errorCode;
	
	public InputParseException(String exMsg){
		super(exMsg);
	}
	
	public InputParseException(ExceptionCodes exceptionCodes, Throwable cause){
		super(exceptionCodes.name(), cause);
		setErrorCode(exceptionCodes.name());
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}