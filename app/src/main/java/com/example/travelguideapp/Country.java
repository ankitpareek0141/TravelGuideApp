package com.example.travelguideapp;

public class Country {
    private int countryId;
    private String name;
    private String capital;
    private String GDP;
    private long population;
    private String imageurl;

    public Country(int countryId, String name, String capital, String GDP, long population, String imageurl) {
        this.countryId = countryId;
        this.name = name;
        this.capital = capital;
        this.GDP = GDP;
        this.population = population;
        this.imageurl = imageurl;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getGDP() {
        return GDP;
    }

    public void setGDP(String GDP) {
        this.GDP = GDP;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
