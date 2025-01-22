package com.entrainement.dao;

import com.entrainement.model.Region;

import javax.enterprise.context.Dependent;
import java.util.List;

@Dependent
public class RegionDao extends Dao {

    public Region findRegionById(long id) {
        return entityManager.find(Region.class, id);
    }

    public List<Region> findAllRegions() {
        return entityManager.createNamedQuery("Region.findAll", Region.class).getResultList();
    }
}