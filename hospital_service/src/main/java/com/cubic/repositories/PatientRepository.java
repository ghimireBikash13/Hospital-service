package com.cubic.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entities.PatientEntity;

@Repository
@Transactional
public class PatientRepository {

	
	private EntityManager entityManager;

	
	public void save(PatientEntity patients) {
		entityManager.persist(patients);
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public PatientEntity getPatients(Long id) {
		
		return entityManager.find(PatientEntity.class, id);
	}

}
