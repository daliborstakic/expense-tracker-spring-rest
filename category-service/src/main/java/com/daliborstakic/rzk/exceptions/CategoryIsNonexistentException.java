package com.daliborstakic.rzk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CategoryIsNonexistentException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Integer idCategory;

	public CategoryIsNonexistentException(String message, Integer idCategory) {
		super(message);
		this.idCategory = idCategory;
	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}
}
