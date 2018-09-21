package com.sdet.presentation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdet.services.WorkoutCategoryService;

@RestController
public class CategoryController {

	@Autowired
	WorkoutCategoryService categoryService;
	
	@RequestMapping("/addCategory")
	public List<String> addCategory(@RequestParam(value = "categoryName") String categoryName) {
		categoryService.addCategory(categoryName);
		List<String> list = new ArrayList<>();
		return list;
	}

}
