package com.sdet.presentation.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdet.model.WorkoutCategory;
import com.sdet.services.WorkoutCategoryService;

@RestController
public class CategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	WorkoutCategoryService categoryService;

	@RequestMapping("/addCategory")
	public WorkoutCategory addCategory(@RequestParam(value = "categoryName") String categoryName) {
		WorkoutCategory category = categoryService.addCategory(categoryName);
		LOGGER.debug("category {}", category);
		return category;
	}

	@RequestMapping("/findAllCategory")
	public List<WorkoutCategory> findAll() {
		return categoryService.getCategories("");

	}

}
