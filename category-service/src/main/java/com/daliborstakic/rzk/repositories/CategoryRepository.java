package com.daliborstakic.rzk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daliborstakic.rzk.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Optional<Category> findByCategoryName(String categoryName);
}
