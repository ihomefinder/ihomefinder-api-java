package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;

public class ClientBoard extends Resource {
	
	public ClientBoard(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public ClientBoard setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getClientId() {
		return this.getter("clientId", Integer.class);
	}
	
	public ClientBoard setClientId(Integer clientId) {
		this.setter("clientId", clientId);
		return this;
	}
	
	public String getBoardId() {
		return this.getter("boardId", String.class);
	}
	
	public ClientBoard setBoardId(String boardId) {
		this.setter("boardId", boardId);
		return this;
	}
	
	public String getAgentCode() {
		return this.getter("agentCode", String.class); 
	}
	
	public ClientBoard setAgentCode(String agentCode) {
		this.setter("agentCode", agentCode);
		return this;
	}
	
	public String getOfficeCode() {
		return this.getter("officeCode", String.class); 
	}
	
	public ClientBoard setOfficeCode(String officeCode) {
		this.setter("officeCode", officeCode);
		return this;
	}
	
	public Client getClient() {
		return this.getter("client", Client.class);
	}
	
	public ClientBoard setClient(Client client) {
		this.setter("client", client);
		return this;
	}
	
	public Board getBoard() {
		return this.getter("board", Board.class);
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"clientId",
			"boardId",
			"agentCode",
			"officeCode"
		);
	}
	
}