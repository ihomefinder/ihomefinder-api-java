package com.ihomefinder.api;

public class ClientAuthentication implements Authentication {
	
	private final String username;
	private final String password;
	
	public ClientAuthentication(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
}