package com.java;

import mockit.Tested;
import mockit.integration.springframework.FakeBeanFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import static org.junit.jupiter.api.Assertions.assertSame;

public class dsl {
    @BeforeClass
    public static void applySpringIntegration(){
        new FakeBeanFactory();
    }

//    @Tested
//    DependencyImpl dependency;
//
//    @Tested(fullyInitialized = true)
//    ExampleService exampleService;
//
//    @Test
//    public void exerciseApplicationCodeWhichLooksUpBeansThroughABeanFactory() {
//        // In code under test:
//        BeanFactory beanFactory = new DefaultListableBeanFactory();
//        ExampleService service = (ExampleService) beanFactory.getBean("exampleService");
//        Dependency dep = service.getDependency();
//
//
//        assertSame(exampleService, service);
//        assertSame(dependency, dep);
//    }
}
