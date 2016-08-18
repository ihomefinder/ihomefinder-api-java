package com.ihomefinder.api.resource;

import java.util.Map;

import com.ihomefinder.api.Constants;
import com.ihomefinder.api.Request;
import com.ihomefinder.api.Resource;
import com.ihomefinder.api.ResourceManager;
import com.ihomefinder.api.exception.ApiException;

public class ClientSession extends Resource {
	
	protected boolean active = true;
	
	public ClientSession() {
		super();
		ClientSession self = this;
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				if(self.active) {
					throw new ApiException("Session has not been logged out");
				}
			}
		});
	}

	public static ClientSession login(String username, String password) {
		Map<String, Object> object = new Request()
			.setUrl(Constants.LOGIN_URL)
			.setMethod("POST")
			.setParameter("username", username)
			.setParameter("password", password)
			.getResponse()
			.getData()
		;
		return ResourceManager.getInstance().load(ClientSession.class, object);
	}
	
	public Integer getClientId() {
		return this.getter("clientId", Integer.class);
	}
	
	public ClientSession setClientId(Integer clientId) {
		this.setter("clientId", clientId);
		return this;
	}
	
	public Client getClient() {
		return this.getter("client", Client.class);
	}
	
	@Override
	protected String[] getFieldNames() {
		return new String[] {
			"clientId",
		};
	}
	
	public void logout() {
		ResourceManager.getInstance().save();
		this.active = false;
	}
	
}