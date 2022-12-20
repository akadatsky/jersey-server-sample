package com.akadatsky.model;

import java.util.List;

public class CompanyWrapper {

    List<Company> result;

    public CompanyWrapper() {
    }

    public CompanyWrapper(List<Company> result) {
        this.result = result;
    }

    public List<Company> getResult() {
        return result;
    }
}
