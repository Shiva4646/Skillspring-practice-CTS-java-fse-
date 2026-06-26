package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll(); // Inherited from JpaRepository
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country); // Inserts or Updates records smoothly
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode) {
        Optional<Country> result = countryRepository.findById(countryCode);
        return result.orElse(null);
    }
}