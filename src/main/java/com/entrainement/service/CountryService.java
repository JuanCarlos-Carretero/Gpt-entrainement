package com.entrainement.service;

import com.entrainement.dao.CountryDao;
import com.entrainement.model.Country;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;

@RequestScoped
public class CountryService {

    @Inject
    private CountryDao countryDao;

    public List<Country> getAllCountrys() {
        return countryDao.findAllCountrys();
    }
    
    public Country getCountryById(int id) {
        return countryDao.findCountryById(id);
    }

    @Transactional
    public void insertCountry(Country Country) {
        countryDao.insertObject(Country);
    }

    @Transactional
    public void updateCountry(int id, Country country) {
        Country existingCountry = countryDao.findCountryById(id);
        if (existingCountry != null) {
            countryDao.updateObject(country);
        }
    }

    @Transactional
    public void deleteCountry(int id) {
        countryDao.deleteObject(getCountryById(id));
    }
}