package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class Boards extends Resources<Board> {

	public static Boards get(Authentication auth, Query query) {
		Boards boards = new Boards(auth);
		boards.init(Url.BOARDS, query);
		return boards;
	}
	
	public Boards(Authentication auth) {
		super(auth);
	}
	
}