package com.sdet.presentation.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdet.exception.ServiceException;
import com.sdet.model.WorkoutCategory;
import com.sdet.services.WorkoutCategoryService;

@RestController
public class CategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	WorkoutCategoryService categoryService;

	@RequestMapping("/addCategory")
	public ResponseEntity<WorkoutCategory> addCategory(@RequestParam(value = "categoryName") String categoryName) {
		WorkoutCategory category = null;
		try {
			category = categoryService.addCategory(categoryName);
			LOGGER.debug("category {}", category);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(category);
		}
		return ResponseEntity.status(HttpStatus.OK).body(category);
	}

	@RequestMapping("/findAllCategory")
	public List<WorkoutCategory> findAll(@RequestParam(value = "categoryName") String categoryName) {
		return categoryService.getAllCategories(categoryName);

	}

}
