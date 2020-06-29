package com.java.inflearnJava;

public class Moim {
    int maxNumberOfAttendees;

    int numberOfEnrollment;

    public boolean isFull(){
        if(maxNumberOfAttendees == 0){
            return false;
        }

        if(numberOfEnrollment<maxNumberOfAttendees){
            return false;
        }

        return true;
    }
}
