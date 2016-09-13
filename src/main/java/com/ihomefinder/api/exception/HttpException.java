package com.ihomefinder.api.exception;

public class HttpException extends ApiException {
	
	private static final long serialVersionUID = 2465568148952093172L;

	public HttpException(String message) {
		super(message);
	}

	public HttpException(Throwable e) {
		super(e);
	}
	
}