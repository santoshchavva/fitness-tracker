package com.sdet.dao;

import org.springframework.data.repository.CrudRepository;

import com.sdet.model.WorkoutCategory;


public interface WorkoutDaoRepository extends CrudRepository<WorkoutCategory, Long> {

}
