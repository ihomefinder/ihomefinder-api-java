package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;

public class Board extends Resource {
	
	public Board(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public Board setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getName() {
		return this.getter("name", Integer.class); 
	}
	
	public Board setName(String name) {
		this.setter("name", name);
		return this;
	}
	
	public String getAbbreviation() {
		return this.getter("abbreviation", String.class);
	}
	
	public Board setAbbreviation(String abbreviation) {
		this.setter("abbreviation", abbreviation);
		return this;
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"name",
			"abbreviation"
		);
	}
	
}