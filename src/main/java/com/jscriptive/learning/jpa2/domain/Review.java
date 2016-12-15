package com.jscriptive.learning.jpa2.domain;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Review extends Jpa2Entity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    private Hotel hotel;

    @Column(nullable = false, name = "idx")
    private int index;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Rating rating;

    @Column(nullable = false)
    //@Temporal(TemporalType.DATE)
    private LocalDate checkInDate;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TripType tripType;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 5000)
    private String details;

    protected Review() {
    }

    public Review(Hotel hotel, int index, ReviewDetails details) {
        Assert.notNull(hotel, "Hotel must not be null");
        Assert.notNull(details, "Details must not be null");
        this.hotel = hotel;
        this.index = index;
        this.rating = details.getRating();
        this.checkInDate = details.getCheckInDate();
        this.tripType = details.getTripType();
        this.title = details.getTitle();
        this.details = details.getDetails();
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    public int getIndex() {
        return this.index;
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
