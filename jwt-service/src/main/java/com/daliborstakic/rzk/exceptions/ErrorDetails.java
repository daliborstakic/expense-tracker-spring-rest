package com.daliborstakic.rzk.exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {
	private String message;
	private LocalDateTime currentDateAndTime;

	public ErrorDetails(String message) {
		this.message = message;
		this.currentDateAndTime = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCurrentDateAndTime() {
		return currentDateAndTime;
	}

	public void setCurrentDateAndTime(LocalDateTime currentDateAndTime) {
		this.currentDateAndTime = currentDateAndTime;
	}
}
