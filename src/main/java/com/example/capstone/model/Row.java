package com.example.capstone.model;

public class Row {
    private String state;
    private int yearsExperience;
    private String country;
    private String organizationSize;
    private int convertedCompensation;

    public Row(String state, int yearsExperience, String country, String organizationSize, int convertedCompensation) {
        this.state = state;
        this.yearsExperience = yearsExperience;
        this.country = country;
        this.organizationSize = organizationSize;
        this.convertedCompensation = convertedCompensation;
    }

    public String getState() {
        return state;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public String getCountry() {
        return country;
    }

    public String getOrganizationSize() {
        return organizationSize;
    }

    public int getConvertedCompensation() {
        return convertedCompensation;
    }
}
