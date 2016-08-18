package com.ihomefinder.api.exception;

import com.ihomefinder.api.Resource;

public class UnsavedResourceException extends ApiException {
	
	private static final long serialVersionUID = -7588371322253719579L;

	public UnsavedResourceException(Resource resource) {
		super("Resource has not been saved");
	}
	
}