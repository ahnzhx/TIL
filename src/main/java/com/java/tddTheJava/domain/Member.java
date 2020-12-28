package com.java.tddTheJava.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String email;

}
