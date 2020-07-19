package com.java.functionalProgramming;

public class Student {
    private String name;
    private String lecture;
    private int credit;
    private int score;

    public Student(String name, String lecture, int credit, int score) {
        this.name = name;
        this.lecture = lecture;
        this.credit = credit;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getLecture() {
        return lecture;
    }

    public int getCredit() {
        return credit;
    }

    public int getScore() {
        return score;
    }
}
