package com.jscriptive.learning.jpa2.service;

import com.jscriptive.learning.jpa2.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Component("hotelService")
@Transactional
class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final ReviewRepository reviewRepository;

    public HotelServiceImpl(HotelRepository hotelRepository,
                            ReviewRepository reviewRepository) {
        this.hotelRepository = hotelRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Hotel> getHotel(City city, String name) {
        Assert.notNull(city, "City must not be null");
        Assert.hasLength(name, "Name must not be empty");
        return this.hotelRepository.findByCityAndName(city, name);
    }

    @Override
    public Page<Review> getReviews(Hotel hotel, Pageable pageable) {
        Assert.notNull(hotel, "Hotel must not be null");
        return this.reviewRepository.findByHotel(hotel, pageable);
    }

    @Override
    public Optional<Review> getReview(Hotel hotel, int reviewNumber) {
        Assert.notNull(hotel, "Hotel must not be null");
        return this.reviewRepository.findByHotelAndIndex(hotel, reviewNumber);
    }

    @Override
    public Review addReview(Hotel hotel, ReviewDetails details) {
        Review review = new Review(hotel, 1, details);
        return this.reviewRepository.save(review);
    }

    @Override
    public ReviewsSummary getReviewSummary(Hotel hotel) {
        Stream<RatingCount> ratingCounts = this.hotelRepository.findRatingCounts(hotel);
        return new ReviewsSummaryImpl(ratingCounts.collect(toList()));
    }

    private static class ReviewsSummaryImpl implements ReviewsSummary {

        private final Map<Rating, Long> ratingCount;

        private ReviewsSummaryImpl(List<RatingCount> ratingCounts) {
            this.ratingCount = ratingCounts.stream()
                    .collect(toMap(RatingCount::getRating, RatingCount::getCount));
        }

        @Override
        public long getNumberOfReviewsWithRating(Rating rating) {
            return this.ratingCount.getOrDefault(rating, 0L);
        }
    }
}