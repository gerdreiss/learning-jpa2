package com.jscriptive.learning.jpa2.service;

import com.jscriptive.learning.jpa2.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface HotelService {

    Optional<Hotel> getHotel(City city, String name);

    Page<Review> getReviews(Hotel hotel, Pageable pageable);

    Optional<Review> getReview(Hotel hotel, int index);

    Review addReview(Hotel hotel, ReviewDetails details);

    ReviewsSummary getReviewSummary(Hotel hotel);

}
