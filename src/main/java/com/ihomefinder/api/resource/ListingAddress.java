package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;

public class ListingAddress extends Resource {
	
	public ListingAddress(Authentication auth) {
		super(auth);
	}
	
	public String getInternalDisplay() {
		return this.getter("internalDisplay", String.class); 
	}
	
	public ListingAddress setInternalDisplay(String internalDisplay) {
		this.setter("internalDisplay", internalDisplay);
		return this;
	}
	
	public String getExternalDisplay() {
		return this.getter("externalDisplay", String.class); 
	}
	
	public ListingAddress setExternalDisplay(String externalDisplay) {
		this.setter("externalDisplay", externalDisplay);
		return this;
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"internalDisplay",
			"externalDisplay"
		);
	}
	
}