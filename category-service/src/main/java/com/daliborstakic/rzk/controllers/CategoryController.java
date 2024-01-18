package com.daliborstakic.rzk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.rzk.exceptions.CategoryAlreadyExistsException;
import com.daliborstakic.rzk.model.Category;
import com.daliborstakic.rzk.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/getCategories")
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}

	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody @Valid Category category) throws CategoryAlreadyExistsException {
		return categoryService.addCategory(category);
	}

	@GetMapping("/getCategory/{idCategory}")
	public Category getCategory(@PathVariable Integer idCategory) {
		return categoryService.getCategory(idCategory);
	}
}
