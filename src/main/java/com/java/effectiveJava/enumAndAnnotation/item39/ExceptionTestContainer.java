package com.java.effectiveJava.enumAndAnnotation.item39;

import java.lang.annotation.*;


// 컨테이너 애너테이션
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTestContainer {
    ExceptionTest[] value();
}
