package com.jscriptive.learning.jpa2.service;


import com.jscriptive.learning.jpa2.domain.City;
import com.jscriptive.learning.jpa2.domain.HotelSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CityService {

    Page<City> findCities(CitySearchCriteria criteria, Pageable pageable);

    Optional<City> getCity(String name, String country);

    Page<HotelSummary> getHotels(City city, Pageable pageable);
}
