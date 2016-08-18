package com.ihomefinder.api;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.ihomefinder.api.exception.ApiException;
import com.ihomefinder.api.exception.HttpException;
import com.mashape.unirest.http.HttpResponse;

public class Response {
	
	private final HttpResponse<String> response;
	private Map<String, Object> object;
	
	public Response(HttpResponse<String> response) {
		this.response = response;
		String body = response.getBody();
		try {
			JSONObject json = new JSONObject(body);
			object = new JsonObjectToMap(json).getResults();
			List<Map<String, Object>> errors = (List<Map<String, Object>>) object.get("errors");
			if(errors != null && !errors.isEmpty()) {
				for(Map<String, Object> error : errors) {
					Integer code = (Integer) error.get("code");
					String message = (String) error.get("message");
					String href = (String) error.get("href");
					throw new ApiException(message);
				}
			}
		} catch (JSONException e) {
			int status = response.getStatus();
			if(status < 200 || status > 299) {
				throw new HttpException("Status " + status);
			}
		}
	}
	
	public Map<String, Object> getData() {
		return this.object;
	}
	
}