package com.java.tddTheJava;

import com.java.tddTheJava.domain.Study;
import com.java.tddTheJava.study.StudyStatus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class StudyTest {

    @Test
    void create(){
        Study study = new Study(10);

        // 3개의 assert 문을 한번에 실행한다.
        assertAll(
                () -> assertNotNull(study),

                // 문자열 연산을 성공, 실패와 상관 없이 한다. 문자열 연산 비용이 걱정되는 경우에는 추천하지 않음
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                "스터디를 처음 만들면 상태값이 " + StudyStatus.DRAFT+"여야 한다."),

                () -> assertTrue(study.getLimit() > 0, "스터디 참석 인원은 최소 1명")

        );

    }

    @Test
    void create2(){
        Study study = new Study(-1);

        // message를 람다식으로 만들면 문자열 연산을 최대한 하지 않는다. (필요한 시점에 함 -> 실패 했을 떄만)
        assertEquals(StudyStatus.DRAFT, study.getStatus(),
                () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT+" 상태다.");

        assertThrows( IllegalArgumentException.class, (Executable) study);
    }

    @Test
    void throwException(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        assertEquals("limit은 0보다 커야한다", exception.getMessage());
    }

    @Test
    void timeoutTest(){
        assertTimeout(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
    }

    @Test
    void testWithConditions(){
        String test_env = System.getenv("TEST_ENV");
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        assumingThat("LOCAL".equalsIgnoreCase(test_env), ()->{
            System.out.println("local");
        });

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void testWithConditions_different_expression(){
        String test_env = System.getenv("TEST_ENV");
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));
        System.out.println(test_env);
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX}) // disabled 도 마찬가지
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
    void testWithConditions2(){
        String test_env = System.getenv("TEST_ENV");
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

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