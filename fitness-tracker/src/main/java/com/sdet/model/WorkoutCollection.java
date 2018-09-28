package com.sdet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name ="workout_collection")
public class WorkoutCollection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="workout_id")
	private Long id;

	@ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private WorkoutCategory category; 
	
	@Column(name="workout_title")
	private String title;
	
	@Column(name ="workout_note")
	private String note;
	
	@Column (name="calories_burn_per_min")
	private int calories;

	public WorkoutCategory getCategory() {
		return category;
	}

	public void setCategory(WorkoutCategory category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "WorkoutCollection [id=" + id + ", category=" + category + ", title=" + title + ", note=" + note
				+ ", calories=" + calories + "]";
	}

}
