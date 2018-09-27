package com.sdet.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdet.dao.WorkoutDaoRepository;
import com.sdet.exception.ServiceException;
import com.sdet.model.WorkoutCategory;
import com.sdet.presentation.controllers.CategoryController;

@Service
public class WorkoutCategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	WorkoutDaoRepository workOutDao;

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

	public List<WorkoutCategory> getAllCategories(final String filterName) throws ServiceException {
		List<WorkoutCategory> list = null;
		try {
			list = workOutDao.findCategory(filterName);
		} catch (Exception e) {
			LOGGER.error("Exception while retreiving workOutCategory ", e);
			throw new ServiceException("Exception retreiving all catogery Names " + list);
		}
		return list;
	}

	public void deleteCategory(Long categoryId) throws ServiceException {
		try {
			 workOutDao.deleteById(categoryId);
		} catch (Exception e) {
			LOGGER.error("Exception while deleting workOutCategory ", e);
			throw new ServiceException("Exception retreiving all catogery Names ");
		}	
	}
	
	

}
