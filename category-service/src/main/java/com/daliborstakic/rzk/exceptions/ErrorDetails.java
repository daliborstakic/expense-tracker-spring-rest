package com.daliborstakic.rzk.exceptions;

import java.time.LocalDateTime;

public class ErrorDetails<T> {
	private String message;
	private T invalidData;
	private LocalDateTime currentDateAndTime;

	public ErrorDetails(String message, T invalidData) {
		this.message = message;
		this.invalidData = invalidData;
		this.currentDateAndTime = LocalDateTime.now();
	}

	public T getInvalidData() {
		return invalidData;
	}

	public void setInvalidData(T invalidData) {
		this.invalidData = invalidData;
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
