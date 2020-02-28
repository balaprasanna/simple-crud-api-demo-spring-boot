package com.bala.crudapi;

public class ErrorResponse {
	private String message;
	public ErrorResponse() {
		super();
	}
	
	public ErrorResponse(String msg) {
		super();
		this.message= msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
