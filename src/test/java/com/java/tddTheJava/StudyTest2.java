package com.java.tddTheJava;

import com.java.tddTheJava.domain.Study;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// @ExtendWith(FindSlowTestExtension.class)
// order 애너테이션을 가지고 순서를 정해준다
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudyTest2 {

    int value = 1;

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension =
            new FindSlowTestExtension(1000L);


    @FastTest
    void fast_case_with_same_conditions(){
        System.out.println("fast");
    }

    @Order(1)
    @SlowTest
    @Tag("slow")
    void slow_case_with_same_conditions() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println("slow");
    }

    @Order(3)
    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10, name= "{displayName}, {currentRepetition}/{totalRepetitions}")
    void create_study(RepetitionInfo repetitionInfo) {
        System.out.println("test:" + repetitionInfo.getCurrentRepetition() + "/" +
                repetitionInfo.getTotalRepetitions());
        System.out.println(value++);
    }

    @Order(2)
    @DisplayName("스터디 만들기")
    // messsage: 메쏘드의 첫번째 파라미터
    @ParameterizedTest(name="{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    void parameterizedTest(String message){
        System.out.println(message);
        System.out.println(value++);
    }

    @DisplayName("스터디 만들기")
    // messsage: 메쏘드의 첫번째 파라미터
    @ParameterizedTest(name="{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    @NullAndEmptySource
    void parameterizedTest2(String message){
        System.out.println(message);
    }

    @DisplayName("스터디 만들기")
    // messsage: 메쏘드의 첫번째 파라미터
    @ParameterizedTest(name="{index} {displayName} message={0}")
    @ValueSource(ints = {10, 20, 40})
    void parameterizedTest3(@ConvertWith(StudyConverter.class) Study study){
        System.out.println(study.getLimit());
    }

    static class StudyConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name="{index} {displayName} message={0}")
    @CsvSource({"10, '자바'", "20, '스프링'"})
    void parameterizedTest4(@AggregateWith(StudyAggregator.class) Study study){
        System.out.println(study);
    }

    // 필수조건 : static innerclass 이거나 public class 로 선언해줘야 한다.
    static class StudyAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }
}
