package com.java.tdd;

import junit.framework.TestCase;

public class triangulateTest extends TestCase {

    private int plus(int augend, int addend){
        return augend + addend;
    }

    public void test(){
        assertEquals(4, plus(3,1));
        assertEquals(7, plus(3,4));
    }

}