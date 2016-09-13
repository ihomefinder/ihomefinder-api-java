package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class Listings extends Resources<Listing> {

	public static Listings get(Authentication auth, Query query) {
		Listings listings = new Listings(auth);
		listings.init(Url.LISTINGS, query);
		return listings;
	}
	
	public Listings(Authentication auth) {
		super(auth);
	}

}