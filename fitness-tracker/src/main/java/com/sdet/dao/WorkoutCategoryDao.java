package com.sdet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdet.model.WorkoutCategory;

@Repository
public interface WorkoutCategoryDao extends JpaRepository<WorkoutCategory, Long>{

}
