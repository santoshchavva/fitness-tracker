package com.sdet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdet.model.WorkoutCategory;

public interface WorkoutDaoRepository extends JpaRepository<WorkoutCategory, Long> {
	
	@Query(value = "SELECT * FROM workout_category WHERE category_name like %?1% ", nativeQuery = true)
	public List<WorkoutCategory> findCategory(final String filterName);

}
