package com.java.tddTheJava;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    @Test
    void create(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("Create");
    }

    @Test
    void create2(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("Create2");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("before all ");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("before each");
    }

    @AfterEach
    void afterEach(){
        System.out.println("after each");
    }
}