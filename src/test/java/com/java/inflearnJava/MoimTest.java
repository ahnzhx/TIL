package com.java.inflearnJava;

import org.junit.Assert;
import org.junit.Test;

public class MoimTest {
    @Test
    public void isFull(){
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnrollment = 10;
        Assert.assertFalse(moim.isFull());
    }
}