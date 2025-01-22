package com.entrainement.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.entrainement.dao.RegionDao;
import com.entrainement.model.Region;

@RequestScoped
public class RegionService {
	@Inject
	private RegionDao regionDao;

	public List<Region> getAllRegions() {
		return regionDao.findAllRegions();
	}

	public Region getRegionById(int id) {
		return regionDao.findRegionById(id);
	}

	@Transactional
	public void insertRegion(Region region) {
		regionDao.insertObject(region);
	}

	@Transactional
	public void updateRegion(int id, Region region) {
		Region existingRegion = regionDao.findRegionById(id);
		if (existingRegion != null) {
			regionDao.updateObject(region);
		}
	}

	@Transactional
	public void deleteRegion(int id) {
		regionDao.deleteObject(getRegionById(id));
	}
}
