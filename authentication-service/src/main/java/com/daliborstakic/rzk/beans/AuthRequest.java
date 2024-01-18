package com.daliborstakic.rzk.beans;

import jakarta.validation.constraints.NotBlank;

public class AuthRequest {
	@NotBlank(message = "Username cannot be blank")
	private String username;

	@NotBlank(message = "Password cannot be blank")
	private String password;

	public AuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
