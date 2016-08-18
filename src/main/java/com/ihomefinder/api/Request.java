package com.ihomefinder.api;

import java.util.HashMap;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Request {
	
	private String url;
	private String method;
	private Map<String, String> headers = new HashMap<>();
	private Map<String, Object> parameters = new HashMap<>();
	
	public Request() {
		headers.put("User-Agent", Constants.USER_AGENT);
		parameters.put("debug", true);
	}
	
	public Request setUrl(String url) {
		this.url = url;
		return this;
	}
	
	public Request setMethod(String method) {
		this.method = method;
		return this;
	}
	
	public Request setParameters(Map<String, Object> parameters) {
		this.parameters.putAll(parameters);
		return this;
	}
	
	public Request setParameter(String name, Object value) {
		this.parameters.put(name, value);
		return this;
	}
	
	public Request addQuery(Query query) {
		if(query != null) {
			query.loadRequest(this);
		}
		return this;
	}
	
	public Response getResponse() {
		HttpResponse<String> httpResponse = null;
		try {
			switch(this.method) {
				case "GET":
					httpResponse = getRequest();
					break;
				case "POST":
					httpResponse = postRequest();
					break;
				case "PUT":
					httpResponse = putRequest();
					break;
				case "DELETE":
					httpResponse = deleteRequest();
					break;
			}
		} catch(UnirestException e) {
			System.out.println(e);
		}
		return new Response(httpResponse);
	}
	
	private HttpResponse<String> getRequest() throws UnirestException {
		return Unirest
			.get(this.url)
			.headers(this.headers)
			.queryString(this.parameters)
			.asString()
		;
	}
	
	private HttpResponse<String> postRequest() throws UnirestException {
		return Unirest
			.post(this.url)
			.headers(this.headers)
			.fields(this.parameters)
			.asString()
		;
	}
	
	private HttpResponse<String> putRequest() throws UnirestException {
		return Unirest
			.put(this.url)
			.headers(this.headers)
			.fields(this.parameters)
			.asString()
		;
	}
	
	private HttpResponse<String> deleteRequest() throws UnirestException {
		return Unirest
			.delete(this.url)
			.headers(this.headers)
			.fields(this.parameters)
			.asString()
		;
	}
	
}