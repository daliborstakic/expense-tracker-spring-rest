package com.daliborstakic.rzk.exceptions;

import java.time.LocalDateTime;

public class ErrorMessage {
	private String message;
	private LocalDateTime currentDateTime;

	public ErrorMessage(String message) {
		super();
		this.message = message;
		this.currentDateTime = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCurrentDateTime() {
		return currentDateTime;
	}

	public void setCurrentDateTime(LocalDateTime currentDateTime) {
		this.currentDateTime = currentDateTime;
	}
}
