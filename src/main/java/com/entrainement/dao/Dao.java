package com.entrainement.dao;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Dependent
public class Dao {

    @PersistenceContext(unitName = "Gpt-entraînement")
	protected EntityManager entityManager;
    
    public void insertObject(Object o) {
        entityManager.persist(o);
    }

    public void updateObject(Object o) {
        entityManager.merge(o);
    }

    public void deleteObject(Object o) {
        if (!entityManager.contains(o)) {
            o = entityManager.merge(o);
        }
        entityManager.remove(o);
    }
}
