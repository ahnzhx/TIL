package com.java.tddTheJava.study;

import com.java.tddTheJava.member.MemberService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@Testcontainers
public class StudyServiceTest2 {

    @Mock
    MemberService memberService;

    // 이렇게 만들면 테스트마다 컨테이너를 만든다. static 을 붙여줘야 함
    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer()
            .withDatabaseName("studyTest");

    @BeforeAll
    static void beforeAll(){
        postgreSQLContainer.start();
        System.out.println(postgreSQLContainer.getJdbcUrl());
    }

    @AfterAll
    static void afterAll(){
        postgreSQLContainer.stop();
    }

    @Test
    void createNewStudy(){

    }

}
