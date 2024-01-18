package com.daliborstakic.rzk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class CategoryAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String categoryName;

	public CategoryAlreadyExistsException(String message, String categoryName) {
		super(message);
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
