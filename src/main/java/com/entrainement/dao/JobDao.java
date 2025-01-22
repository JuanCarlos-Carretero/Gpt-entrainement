package com.entrainement.dao;

import com.entrainement.model.Job;

import javax.enterprise.context.Dependent;
import java.util.List;

@Dependent
public class JobDao extends Dao {

    public Job findJobById(long id) {
        return entityManager.find(Job.class, id);
    }

    public List<Job> findAllJobs() {
        return entityManager.createNamedQuery("Job.findAll", Job.class).getResultList();
    }
}