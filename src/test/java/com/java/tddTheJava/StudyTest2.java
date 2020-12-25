package com.java.tddTheJava;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class StudyTest2 {

    @FastTest
    void fast_case_with_same_conditions(){
        System.out.println("fast");
    }

    @Test
    @Tag("slow")
    void slow_case_with_same_conditions(){
        System.out.println("slow");
    }
}
