package com.sdet.dao;

import java.io.Serializable;
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

public class WorkoutDaoRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements WorkoutDaoRepository<T, ID> {

	private EntityManager entityManager;

	public WorkoutDaoRepositoryImpl(JpaEntityInformation<T, ?> entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<T> findCategory(@Param("filterName") String filterName) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getDomainClass());
		Root<T> root = query.from(getDomainClass());
		query.select(root).where(builder.like(root.<String>get("categoryName"), "%" + filterName + "%"));
		TypedQuery<T> q = entityManager.createQuery(query);
		return q.getResultList();
	}

}
