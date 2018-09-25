package com.sdet.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdet.dao.WorkoutDaoRepository;
import com.sdet.model.WorkoutCategory;
import com.sdet.presentation.controllers.CategoryController;

@Service
public class WorkoutCategoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	
	@Autowired
	WorkoutDaoRepository workOutDao;
	
	
	public WorkoutCategory addCategory(final String categoryName) {
		WorkoutCategory category = new WorkoutCategory();
		category.setCategoryName(categoryName);
		workOutDao.save(category);
		LOGGER.debug("in service {}", categoryName);
		return category;
	}

}
