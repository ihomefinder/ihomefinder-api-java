package com.ihomefinder.api.exception;

public class InvalidArgumentException extends ApiException {
	
	private static final long serialVersionUID = -2741968446224544627L;

	public InvalidArgumentException(Object value, Class<?> expected) {
		super(value.getClass() + " provided, however " + expected + " was expected");
	}
	
}