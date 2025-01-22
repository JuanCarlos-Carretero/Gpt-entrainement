package com.entrainement.dao;

import com.entrainement.model.Location;

import javax.enterprise.context.Dependent;
import java.util.List;

@Dependent
public class LocationDao extends Dao {

    public Location findLocationById(long id) {
        return entityManager.find(Location.class, id);
    }

    public List<Location> findAllLocations() {
        return entityManager.createNamedQuery("Location.findAll", Location.class).getResultList();
    }
}