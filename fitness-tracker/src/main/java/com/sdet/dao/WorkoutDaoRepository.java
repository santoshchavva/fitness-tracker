package com.sdet.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sdet.model.WorkoutCategory;


public interface WorkoutDaoRepository extends CrudRepository<WorkoutCategory, Long> {
	
	public List<WorkoutCategory> findCategory(final String filterName);

}
