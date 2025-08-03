package com.zad.excellence.practice.basic.intercommunication;

public class MessageResource {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageResource(String msg) {
		super();
		this.message = msg;
	}

	@Override
	public String toString() {

		return this.message;
	}

}
