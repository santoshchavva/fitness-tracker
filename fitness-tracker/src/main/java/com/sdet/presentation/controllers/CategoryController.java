package com.sdet.presentation.controllers;

import java.util.ArrayList;
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
	public List<WorkoutCategory> addCategory(@RequestParam(value = "categoryName") String categoryName) {
		WorkoutCategory category = categoryService.addCategory(categoryName);
		List<WorkoutCategory> list = new ArrayList<>();
		list.add(category);
		LOGGER.debug("category {}",list);
		return list;
	}

}
