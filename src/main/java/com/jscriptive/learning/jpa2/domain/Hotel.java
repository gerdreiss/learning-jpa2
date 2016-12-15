package com.jscriptive.learning.jpa2.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Hotel extends Jpa2Entity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @NaturalId
    private City city;

    @Column(nullable = false)
    @NaturalId
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String zip;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
    private Set<Review> reviews;

    protected Hotel() {
    }

    public Hotel(City city, String name) {
        this.city = city;
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }
}

