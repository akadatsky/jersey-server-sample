package com.akadatsky.model;

import java.util.Objects;

public class Company {
    private int id;
    private String name;
    private String description;
    private String industry;

    public Company() {
    }

    public Company(int id, String name, String description, String industry) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.industry = industry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && name.equals(company.name) && description.equals(company.description) && industry.equals(company.industry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, industry);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIndustry() {
        return industry;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
