package com.java.effectiveJava.item39;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    @Test
    public static void m1(){}

    @Test
    public void m5(){}

    @Test
    public static void m7(){
        throw new RuntimeException("실패");
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2(){ // 성공
        int i =0;
        i = i/i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m6(){ // 실패 (다른 예외 발생)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m8(){ // 실패(예외가 발생하지 않음)
    }

    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void doublyBad(){ // 성공해야 한다.
        List<String> list = new ArrayList<>();
        list.add(5, null);
    }

    public void handlingRepeatableAnnotation(){

    }

    public static void main(String[] args) {
            //m1();
            //new Sample().m5();
            //m7();
        m2();
//        m6();
//        m8();
    }
}
