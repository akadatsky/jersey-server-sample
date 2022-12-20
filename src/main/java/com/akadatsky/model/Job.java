package com.akadatsky.model;

import java.util.Objects;

public class Job {
    private int id;
    private int companyId;
    private String title;
    private String description;
    private String city;

    public Job() {
    }

    public Job(int id, int companyId, String title, String description, String city) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.description = description;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id && companyId == job.companyId && title.equals(job.title) && description.equals(job.description) && city.equals(job.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, title, description, city);
    }

    public int getId() {
        return id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
