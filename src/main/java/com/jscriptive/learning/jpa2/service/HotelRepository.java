package com.jscriptive.learning.jpa2.service;

import com.jscriptive.learning.jpa2.domain.City;
import com.jscriptive.learning.jpa2.domain.Hotel;
import com.jscriptive.learning.jpa2.domain.HotelSummary;
import com.jscriptive.learning.jpa2.domain.RatingCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface HotelRepository extends Repository<Hotel, Long> {

    Optional<Hotel> findByCityAndName(City city, String name);

    @Query("select h.city as city, h.name as name, avg(r.rating) as averageRating "
            + "from Hotel h left outer join h.reviews r where h.city = ?1 group by h")
    Page<HotelSummary> findByCity(City city, Pageable pageable);

    @Query("select r.rating as rating, count(r) as count "
            + "from Review r where r.hotel = ?1 group by r.rating order by r.rating DESC")
    Stream<RatingCount> findRatingCounts(Hotel hotel);

}
