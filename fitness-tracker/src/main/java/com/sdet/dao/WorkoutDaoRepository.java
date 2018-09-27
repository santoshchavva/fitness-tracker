package com.sdet.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface WorkoutDaoRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
	
	public List<T> findCategory(final String filterName);

}
