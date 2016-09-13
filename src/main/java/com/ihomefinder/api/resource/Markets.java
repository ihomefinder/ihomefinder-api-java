package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class Markets extends Resources<Market> {

	public static Markets get(Authentication auth, Query query) {
		Markets markets = new Markets(auth);
		markets.init(Url.MARKETS, query);
		return markets;
	}
	
	public Markets(Authentication auth) {
		super(auth);
	}
	
}