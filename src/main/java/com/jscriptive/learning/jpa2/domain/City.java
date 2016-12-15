package com.jscriptive.learning.jpa2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class City extends Jpa2Entity {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String map;

    protected City() {
    }

    public City(String name, String state, String country, String map) {
        this.name = name;
        this.state = state;
        this.country = country;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getMap() {
        return map;
    }

    @Override
    public String toString() {
        return getName() + ", " + getState() + ", " + getCountry();
    }
}

