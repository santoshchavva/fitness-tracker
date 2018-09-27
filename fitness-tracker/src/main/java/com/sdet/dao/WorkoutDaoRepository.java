package com.sdet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdet.model.WorkoutCategory;

@SuppressWarnings("hiding")
public interface WorkoutDaoRepository<T, Long> extends JpaRepository<T, Long> {
	
	public List<WorkoutCategory> findCategory(final String filterName);

}
