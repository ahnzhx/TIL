package com.java.tddTheJava.study;

import com.java.tddTheJava.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@Testcontainers
@Slf4j
@ContextConfiguration(initializers = StudyServiceTest2.ContainerPropertyInitializer.class)
public class StudyServiceTest2 {

    @Mock
    MemberService memberService;

    @Autowired
    StudyRepository studyRepository;

//    @Autowired
//    Environment environment;

    @Value("${container.port}")
    int port;

    // 이렇게 만들면 테스트마다 컨테이너를 만든다. static 을 붙여줘야 함
//    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Container
    static GenericContainer postgreSQLContainer = new GenericContainer("postgres")
            .withExposedPorts(5432)
            .withEnv("POSTGRES_PASSWORD", "studytest")
            .withEnv("POSTGRES_DB", "studyTest");

//    @Container
//    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer().withDatabaseName("studyTest");

    @BeforeEach
    void beforeEach(){
        System.out.println("//////////////////////");
//        System.out.println(postgreSQLContainer.getMappedPort(5432));
//        System.out.println(environment.getProperty("container.port"));
//        System.out.println(port);
//        studyRepository.deleteAll();
    }

    @Test
    void createNewStudy(){

    }

    static class ContainerPropertyInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

        @Override
        public void initialize(ConfigurableApplicationContext context) {
            TestPropertyValues.of("container.port="+postgreSQLContainer.getMappedPort(5432))
                                .applyTo(context.getEnvironment());

        }
    }

}
