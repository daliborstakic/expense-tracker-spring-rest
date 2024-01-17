package com.daliborstakic.rzk.exceptions;

public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	private String username;

	public UserAlreadyExistsException(String username) {
		super();
		this.setUsername(username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
