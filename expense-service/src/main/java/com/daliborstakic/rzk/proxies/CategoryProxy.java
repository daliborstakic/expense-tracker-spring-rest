package com.daliborstakic.rzk.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.daliborstakic.rzk.model.Category;

@FeignClient(name = "category-service", url = "http://localhost:8787/categories")
public interface CategoryProxy {
	@GetMapping("/getCategory/{idCategory}")
	public Category getCategory(@PathVariable Integer idCategory);
}
