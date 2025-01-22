package com.entrainement.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.entrainement.dao.LocationDao;
import com.entrainement.model.Location;

@RequestScoped
public class LocationService {
	@Inject
	private LocationDao locationDao;

	public List<Location> getAllLocations() {
		return locationDao.findAllLocations();
	}

	public Location getLocationById(int id) {
		return locationDao.findLocationById(id);
	}

	@Transactional
	public void insertLocation(Location location) {
		locationDao.insertObject(location);
	}

	@Transactional
	public void updateLocation(int id, Location location) {
		Location existingLocation = locationDao.findLocationById(id);
		if (existingLocation != null) {
			locationDao.updateObject(location);
		}
	}

	@Transactional
	public void deleteLocation(int id) {
		locationDao.deleteObject(getLocationById(id));
	}
}
