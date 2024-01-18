package com.daliborstakic.rzk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	private String username;

	public UserAlreadyExistsException(String message, String username) {
		super(message);
		this.setUsername(username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
