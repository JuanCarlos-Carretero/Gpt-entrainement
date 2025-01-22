package com.entrainement.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.entrainement.dao.JobDao;
import com.entrainement.model.Job;

@RequestScoped
public class JobService {

	@Inject
	private JobDao jobDao;

	public List<Job> getAllJobs() {
		return jobDao.findAllJobs();
	}

	public Job getJobById(int id) {
		return jobDao.findJobById(id);
	}

	@Transactional
	public void insertJob(Job job) {
		jobDao.insertObject(job);
	}

	@Transactional
	public void updateJob(int id, Job job) {
		Job existingJob = jobDao.findJobById(id);
		if (existingJob != null) {
			jobDao.updateObject(job);
		}
	}

	@Transactional
	public void deleteJob(int id) {
		jobDao.deleteObject(getJobById(id));
	}
}
