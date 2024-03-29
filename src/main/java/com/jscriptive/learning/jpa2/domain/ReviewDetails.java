package com.jscriptive.learning.jpa2.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class ReviewDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private Rating rating;

    private LocalDate checkInDate;

    private TripType tripType;

    private String title;

    private String details;

    public ReviewDetails() {
    }

    public Rating getRating() {
        return this.rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public LocalDate getCheckInDate() {
        return this.checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public TripType getTripType() {
        return this.tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
