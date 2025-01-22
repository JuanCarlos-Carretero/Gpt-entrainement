package com.entrainement.dao;

import com.entrainement.model.Country;

import javax.enterprise.context.Dependent;
import java.util.List;

@Dependent
public class CountryDao extends Dao {

    public Country findCountryById(long id) {
        return entityManager.find(Country.class, id);
    }

    public List<Country> findAllCountrys() {
        return entityManager.createNamedQuery("Country.findAll", Country.class).getResultList();
    }
}