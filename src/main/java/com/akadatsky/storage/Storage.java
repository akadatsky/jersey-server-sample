package com.akadatsky.storage;

import com.akadatsky.model.Company;
import com.akadatsky.model.Job;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Storage {

    public static Storage instance = new Storage();

    private int jobIndex = 1;
    private int companyIndex = 1;

    private final Set<Company> companies = new HashSet<>();
    private final Set<Job> jobs = new HashSet<>();

    public Storage() {
    }

    public int getNextJobIndex() {
        return jobIndex++;
    }

    public int getNextCompanyIndex() {
        return companyIndex++;
    }


    public void saveCompany(Company company) {
        companies.add(company);
    }

    public List<Company> getCompanies() {
        return new ArrayList<>(companies);
    }

    public void saveJob(Job job) {
        jobs.add(job);
    }

    public List<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    public Company getCompanyById(int id) {
        for (Company company : companies) {
            if (company.getId() == id) {
                return company;
            }
        }
        return null;
    }

    public List<Job> getJobsByCompanyId(int companyId) {
        List<Job> result = new ArrayList<>();
        for (Job job : jobs) {
            if (job.getCompanyId() == companyId) {
                result.add(job);
            }
        }
        return result;
    }


}
