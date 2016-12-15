package com.jscriptive.learning.jpa2.service;

import com.jscriptive.learning.jpa2.domain.Hotel;
import com.jscriptive.learning.jpa2.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ReviewRepository extends Repository<Review, Long> {

    Page<Review> findByHotel(Hotel hotel, Pageable pageable);

    Optional<Review> findByHotelAndIndex(Hotel hotel, int index);

    Review save(Review review);

}
