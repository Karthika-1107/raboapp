package com.raboapp.exception;

public class UnSupportedMediaTypeException extends InputParseException{

	private static final long serialVersionUID = 1L;

	public UnSupportedMediaTypeException() {
		super(ExceptionCodes.UNSOPPORTED_MEDIA_TYPE.name());
	}

}
