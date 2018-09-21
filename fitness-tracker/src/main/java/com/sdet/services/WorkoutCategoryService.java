package com.sdet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdet.dao.WorkoutCategoryDao;
import com.sdet.model.WorkoutCategory;

@Service
public class WorkoutCategoryService {
	
	@Autowired
	WorkoutCategoryDao workOutDao;
	
	public WorkoutCategory addCategory(final String categoryName) {
		WorkoutCategory category = new WorkoutCategory();
		category.setCategoryName(categoryName);
		return workOutDao.save(category);
	}

}
