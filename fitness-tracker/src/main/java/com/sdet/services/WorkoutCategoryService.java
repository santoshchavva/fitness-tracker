package com.sdet.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdet.dao.WorkoutDaoRepositoryImpl;
import com.sdet.exception.ServiceException;
import com.sdet.model.WorkoutCategory;
import com.sdet.presentation.controllers.CategoryController;

@Service
public class WorkoutCategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	WorkoutDaoRepositoryImpl workOutDao;

	public WorkoutCategory addCategory(final String categoryName) throws ServiceException {
		WorkoutCategory category = new WorkoutCategory();
		category.setCategoryName(categoryName);
		try {
			workOutDao.save(category);
		} catch (Exception e) {
			LOGGER.error("Exception while saving workOutCategory ", e);
			throw new ServiceException("Exception persisting catogery Name " + categoryName);
		}
		LOGGER.debug("Save service name {} is success ", categoryName);
		return category;
	}

	public List<WorkoutCategory> getAllCategories(final String filterName) {
		List<WorkoutCategory> list = workOutDao.findCategory(filterName);
		return list;
	}

}
