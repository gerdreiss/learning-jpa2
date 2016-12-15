package com.jscriptive.learning.jpa2.service;


import com.jscriptive.learning.jpa2.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface CityRepository extends Repository<City, Long> {

    Page<City> findAll(Pageable pageable);

    Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name, String country, Pageable pageable);

    Optional<City> findByNameAndCountryAllIgnoringCase(String name, String country);

}
