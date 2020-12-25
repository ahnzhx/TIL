package com.java.tddTheJava;

public class Study {

    private StudyStatus status = StudyStatus.DRAFT;

    private int limit;

    private String name;

    public Study(int limit, String name) {
        this.limit = limit;
        this.name = name;
    }

    public Study(int limit) {
        if(limit < 0){
            throw new IllegalArgumentException("limit은 0보다 커야한다");
        }
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return status;
    }

    public void setStatus(StudyStatus status) {
        this.status = status;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getName() {
        return name;
    }
}
