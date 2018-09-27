package com.sdet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sdet.model.WorkoutCategory;

@Repository
public class WorkoutDaoRepositoryImpl extends SimpleJpaRepository<WorkoutCategory, Long>
		implements WorkoutDaoRepository {

	private EntityManager entityManager;

	public WorkoutDaoRepositoryImpl(JpaEntityInformation<WorkoutCategory, ?> entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	// @Query("SELECT u FROM WorkoutCategory u WHERE u.category_name like
	// %:filterName%")
	public List<WorkoutCategory> findCategory(@Param("filterName") String filterName) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<WorkoutCategory> query = builder.createQuery(WorkoutCategory.class);
		Root<WorkoutCategory> root = query.from(WorkoutCategory.class);
		query.select(root).where(builder.like(root.<String>get("categoryName"), "%" + filterName + "%"));
		TypedQuery<WorkoutCategory> q = entityManager.createQuery(query);
		return q.getResultList();
	}

}
