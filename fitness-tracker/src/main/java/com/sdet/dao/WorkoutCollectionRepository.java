package com.sdet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdet.model.WorkoutCollection;

public interface WorkoutCollectionRepository extends JpaRepository<WorkoutCollection, Long> {
	
	@Query(value = "SELECT * FROM workout_collection WHERE workout_title like %?1% ", nativeQuery = true)
	public List<WorkoutCollection> filterWorkouts(final String filterName);

}
