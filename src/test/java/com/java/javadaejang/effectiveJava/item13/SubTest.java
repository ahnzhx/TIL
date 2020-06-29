package com.java.javadaejang.effectiveJava.item13;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class SubTest {

    @Test
    @DisplayName("재정의가 가능한 메소드를 상위 클래스 clone에서 호출하면 하위 클래스의 메소드가 실행된다.")
    public void testClone() {
        Sub sub = new Sub();
        assertEquals("super", sub.type);
        Sub clone = sub.clone();
        assertEquals("sub", clone.type);
    }

}