package com.cognizant.ormlearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside Data JPA main entry context routine...");

        // 1. Run Operation: Insert sample record values to populate the table
        testAddCountry();

        // 2. Run Operation: Query all record assets back from local database
        testGetAllCountries();
    }

    private static void testAddCountry() {
        LOGGER.info("Executing Transactional Insertion Test...");
        Country newCountry = new Country("IN", "India");
        countryService.addCountry(newCountry);
        LOGGER.info("Successfully persisted country code reference: IN");
    }

    private static void testGetAllCountries() {
        LOGGER.info("Executing Retrieval Test Operations...");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Persisted Catalog Country Collections: {}", countries);
    }
}