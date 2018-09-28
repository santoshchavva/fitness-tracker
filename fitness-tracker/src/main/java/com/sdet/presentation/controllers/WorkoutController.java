package com.sdet.presentation.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdet.exception.ServiceException;
import com.sdet.model.WorkoutCollection;
import com.sdet.services.WorkoutCollectionService;

@RestController
public class WorkoutController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkoutController.class);
	
	@Autowired
	private WorkoutCollectionService workoutService;
	
	@RequestMapping(value = "/deleteWorkout/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteWorkout(@PathVariable("id") Long id) {
		try {
			workoutService.deleteWorkout(id);
		} catch (ServiceException e) {
			LOGGER.error("Error deleting workout", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@RequestMapping(value = "/addWorkout", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<WorkoutCollection> addWorkoutDetails(@RequestBody WorkoutCollection workout) {
		LOGGER.debug("Value {}", workout);
		WorkoutCollection result=null;
		try {
			result = workoutService.createWorkOut(workout);
		} catch (ServiceException e) {
			LOGGER.error("Error creating workout", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@RequestMapping(value = "/findWorkouts")
	public ResponseEntity<List<WorkoutCollection>> filterWorkout(@RequestParam(value = "workoutTitle", required = false, defaultValue = "") String filterText) {
		List<WorkoutCollection> result = null;
		try {
			LOGGER.debug("find workouts by filtering title on {}", filterText);
			result = workoutService.findWorkouts(filterText);
		} catch (ServiceException e) {
			LOGGER.error("Error finding workouts", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

}
