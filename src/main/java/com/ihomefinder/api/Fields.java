package com.ihomefinder.api;

import java.util.ArrayList;
import java.util.Arrays;

public class Fields extends ArrayList<String> {
	
	private static final long serialVersionUID = 8743905710482685250L;

	public Fields() {
		
	}
	
	public Fields(String... fields) {
		this.addAll(Arrays.asList(fields));
	}
	
}