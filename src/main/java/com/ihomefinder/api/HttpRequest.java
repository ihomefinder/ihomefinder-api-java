package com.ihomefinder.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ihomefinder.api.exception.HttpException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

public class HttpRequest {

	private String url;
	private String method;
	private final Authentication auth;
	private Map<String, String> headers = new HashMap<>();
	private Map<String, Object> pathParameters = new HashMap<>();
	private Map<String, Object> parameters = new HashMap<>();
	
	public HttpRequest(Authentication auth) {
		this.auth = auth;
		headers.put("User-Agent", Constants.USER_AGENT);
		if(Constants.DEBUG) {
			parameters.put("debug", true);
		}
	}
	
	public HttpRequest setUrl(String url) {
		this.url = url;
		return this;
	}
	
	public HttpRequest setMethod(String method) {
		this.method = method;
		return this;
	}
	
	public HttpRequest setPathParameters(Map<String, Object> parameters) {
		this.pathParameters.putAll(parameters);
		return this;
	}
	
	public HttpRequest setPathParameter(String name, Object value) {
		this.pathParameters.put(name, value);
		return this;
	}
	
	public HttpRequest setParameters(Map<String, Object> parameters) {
		this.parameters.putAll(parameters);
		return this;
	}
	
	public HttpRequest setParameter(String name, Object value) {
		this.parameters.put(name, value);
		return this;
	}
	
	public HttpRequest addQuery(Query query) {
		if(query != null) {
			query.loadRequest(this);
		}
		return this;
	}
	
	public HttpResponse getResponse() {
		Map<String, Object> debug = new HashMap<>();
		debug.put("url", url);
		debug.put("method", method);
		debug.put("headers", headers);
		debug.put("parameters", parameters);
		debug.put("pathParameters", pathParameters);
		Log.debug(debug);
		com.mashape.unirest.http.HttpResponse<String> httpResponse = null;
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
			throw new HttpException(e);
		}
		int status = httpResponse.getStatus();
		if(status < 200 || status > 299) {
			Log.debug(httpResponse.getBody());
			throw new HttpException("Status " + status);
		}
		return new HttpResponse(httpResponse);
	}
	
	private com.mashape.unirest.http.HttpResponse<String> getRequest() throws UnirestException {
		GetRequest request = Unirest
			.get(url)
			.basicAuth(auth.getUsername(), auth.getPassword())
			.headers(headers)
		;
		request = (GetRequest) replacePathParameters(request);		return request
			.queryString(parameters)
			.asString()
		;
	}
	
	private com.mashape.unirest.http.HttpResponse<String> postRequest() throws UnirestException {
		HttpRequestWithBody request = Unirest
			.post(url)
			.basicAuth(auth.getUsername(), auth.getPassword())
			.headers(headers)
		;
		request = (HttpRequestWithBody) replacePathParameters(request);
		return request
			.fields(parameters)
			.asString()
		;
	}
	
	private com.mashape.unirest.http.HttpResponse<String> putRequest() throws UnirestException {
		HttpRequestWithBody request = Unirest
			.put(this.url)
			.basicAuth(auth.getUsername(), auth.getPassword())
			.headers(headers)
		;
		request = (HttpRequestWithBody) replacePathParameters(request);
		return request
			.fields(parameters)
			.asString()
		;
	}
	
	private com.mashape.unirest.http.HttpResponse<String> deleteRequest() throws UnirestException {
		HttpRequestWithBody request = Unirest
			.delete(url)
			.basicAuth(auth.getUsername(), auth.getPassword())
			.headers(headers)
		;
		request = (HttpRequestWithBody) replacePathParameters(request);
		return request
			.fields(parameters)
			.asString()
		;
	}
	
	private com.mashape.unirest.request.HttpRequest replacePathParameters(com.mashape.unirest.request.HttpRequest request) {
		for(Entry<String, Object> entry : pathParameters.entrySet()) {
			String name = entry.getKey();
			Object value = entry.getValue();
			request = request.routeParam(name, value.toString());
		}
		return request;
	}
	
}