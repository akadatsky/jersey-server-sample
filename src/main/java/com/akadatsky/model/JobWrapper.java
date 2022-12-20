package com.akadatsky.model;

import java.util.List;

public class JobWrapper {

    List<Job> result;

    public JobWrapper() {
    }

    public JobWrapper(List<Job> result) {
        this.result = result;
    }

    public List<Job> getResult() {
        return result;
    }
}
