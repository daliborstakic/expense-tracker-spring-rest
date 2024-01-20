package com.daliborstakic.rzk.exceptions;

import java.time.LocalDateTime;

public class FeignErrorEntity {
	private int httpStatus;
	private String responseBody;
	private LocalDateTime currentDateTime;

	public FeignErrorEntity(int httpStatus, String responseBody) {
		super();
		this.httpStatus = httpStatus;
		this.responseBody = responseBody;
		this.currentDateTime = LocalDateTime.now();
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public LocalDateTime getCurrentDateTime() {
		return currentDateTime;
	}

	public void setCurrentDateTime(LocalDateTime currentDateTime) {
		this.currentDateTime = currentDateTime;
	}
}
