package com.example.capstone.model;

public class GenerateSalary {
    int YearsOfExperience;
    String State;
    String OrganizationSize;

    public GenerateSalary(int yearsOfExperience, String state, String organizationSize) {
        YearsOfExperience = yearsOfExperience;
        State = state;
        OrganizationSize = organizationSize;
    }

    public int getYearsOfExperience() {
        return YearsOfExperience;
    }

    public String getState() {
        return State;
    }

    public String getOrganizationSize() {
        return OrganizationSize;
    }
}
