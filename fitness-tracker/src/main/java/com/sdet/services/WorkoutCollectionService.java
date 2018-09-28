package com.sdet.services;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdet.dao.WorkoutCollectionRepository;
import com.sdet.dao.WorkoutDaoRepository;
import com.sdet.exception.ServiceException;
import com.sdet.model.WorkoutCollection;

@Service
public class WorkoutCollectionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkoutCollectionService.class);
	
	@Autowired
	WorkoutDaoRepository workOutDao;

	
	@Autowired
	WorkoutCollectionRepository collectionDao;
	
	public WorkoutCollection createWorkOut(final WorkoutCollection collection) throws ServiceException {
		WorkoutCollection saved = null;
		try {
			//collection.setCategory(workOutDao.getOne(collection.getCategory().getId()));
			saved = collectionDao.save(collection);
		} catch (Exception e) {
			LOGGER.error("Error saving workout Collection ", e);
			throw new ServiceException("Exception during saving workout ");
		}

		return saved;
	}
	
	public List<WorkoutCollection> findWorkouts (final String filterString) throws ServiceException {
		List<WorkoutCollection> result = null;
		try {
			result = collectionDao.filterWorkouts(filterString);
		} catch (Exception e) {
			LOGGER.error("Error retreiving workouts ", e);
			throw new ServiceException(" Exception retreiving workouts ");
		}
		return result;
	} 
	
	public void deleteWorkout(Long workoutId) throws ServiceException {
		try {
			LOGGER.debug("DeleteRequest for id {}",workoutId);
			collectionDao.deleteById(workoutId);
		} catch (Exception e) {
			LOGGER.error("Exception while deleting workOutCategory ", e);
			throw new ServiceException("Exception retreiving all catogery Names ");
		}
	}

}
