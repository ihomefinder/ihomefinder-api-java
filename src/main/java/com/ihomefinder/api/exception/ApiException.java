package com.ihomefinder.api.exception;

public class ApiException extends RuntimeException {
	
	private static final long serialVersionUID = 5162479649241356232L;

	public ApiException() {
		super();
	}
	
	public ApiException(Throwable e) {
		super(e);
	}
	
	public ApiException(String message) {
		super(message);
	}
	
}