package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Resources;

public class ListingPhotos extends Resources<ListingPhoto> {
	
	public ListingPhotos(Authentication auth) {
		super(auth);
	}
	
}