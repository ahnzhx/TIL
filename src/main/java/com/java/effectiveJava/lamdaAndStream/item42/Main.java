package com.java.effectiveJava.lamdaAndStream.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    List<String> words = Arrays.asList("ganada", "lamabasa");

    public void oldStyle(){

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
    }

    public void newStyle(){
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }

    public void comparatorGenerateMethod(){
        Collections.sort(words, Comparator.comparingInt(String::length));
    }

    public void shortestWayToCompareString(){
        words.sort(Comparator.comparingInt(String::length));
    }

}
