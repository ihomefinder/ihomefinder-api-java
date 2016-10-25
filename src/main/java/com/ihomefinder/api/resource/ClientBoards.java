package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class ClientBoards extends Resources<ClientBoard> {

	public static ClientBoards get(Authentication auth, Query query) {
		ClientBoards clientBoards = new ClientBoards(auth);
		clientBoards.init(Url.CLIENT_BOARDS, query);
		return clientBoards;
	}
	
	public ClientBoards(Authentication auth) {
		super(auth);
	}
	
}