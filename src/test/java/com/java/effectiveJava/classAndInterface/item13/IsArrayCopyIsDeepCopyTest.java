package com.java.effectiveJava.classAndInterface.item13;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsArrayCopyIsDeepCopyTest {

    @Test
    public void isDeepCopy() throws CloneNotSupportedException {
        IsArrayCopyIsDeepCopy originalValue = new IsArrayCopyIsDeepCopy();
        System.out.println("originalValue의 주소값: "+ originalValue.getIntegerArray());
        IsArrayCopyIsDeepCopy clonedValue = originalValue.clone();

        System.out.println("clonedValue의 주소값: "+ clonedValue.getIntegerArray());
        assertNotEquals(originalValue.getIntegerArray(), clonedValue.getIntegerArray());


    }

}