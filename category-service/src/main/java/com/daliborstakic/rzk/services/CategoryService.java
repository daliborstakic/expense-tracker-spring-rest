package com.daliborstakic.rzk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.exceptions.CategoryAlreadyExistsException;
import com.daliborstakic.rzk.exceptions.CategoryIsNonexistentException;
import com.daliborstakic.rzk.model.Category;
import com.daliborstakic.rzk.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	public Category addCategory(Category category) throws CategoryAlreadyExistsException {
		Optional<Category> existingCategory = categoryRepository.findByCategoryName(category.getCategoryName());

		if (existingCategory.isPresent())
			throw new CategoryAlreadyExistsException("The entered category already exists in the system!",
					category.getCategoryName());

		return categoryRepository.save(category);
	}

	public Category getCategory(Integer idCategory) {
		Optional<Category> existingCategory = categoryRepository.findById(idCategory);

		if (existingCategory.isEmpty())
			throw new CategoryIsNonexistentException("The given category doesn't exists!", idCategory);

		return existingCategory.get();
	}
}
