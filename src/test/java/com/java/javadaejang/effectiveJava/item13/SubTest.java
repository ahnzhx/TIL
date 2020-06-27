package com.java.javadaejang.effectiveJava.item13;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class SubTest {

    @Test
    @DisplayName("재정의가 가능한 메소드를 상위 클래스 clone에서 호출하면 하위 클래스의 메소드가 실행된다.")
    public void testClone() {
        //Sub 객체를 생성하고 clone했을때 overrideMe 메소드가 상위 클래스인 Sup의 clone에서 호출하고 있더라도
        // Sub 객체의 overrideMe 메소드가 호출되어서 기존 Sub 객체의 값이 변하고
        //String temp 필드에 값이 할당되기 전에 출력해서 null이 출력된다.
        Sub sub = new Sub();
        assertEquals("super", sub.type);
        Sub clone = sub.clone();
        assertEquals("sub", sub.type);
    }

}