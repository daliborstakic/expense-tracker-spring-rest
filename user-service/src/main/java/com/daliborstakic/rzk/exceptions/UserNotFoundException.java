package com.daliborstakic.rzk.exceptions;

public class UserNotFoundException extends Exception {
	private String username;

	public UserNotFoundException(String username) {
		super();
		this.username = username;
	}
}
