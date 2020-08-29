package com.java.effectiveJava.generic.item26;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RawTypeTest {

    private static Set<Integer> test(){
        Set<Integer> setTest = new HashSet<>();
        setTest.add(1);
        setTest.add(2);
        setTest.add(1);

        List<String> strList = new LinkedList<>();

        return setTest;
    }

    public static void main(String[] args) {

        for(Integer e : test()){
            System.out.println(e);
        }
    }
}
