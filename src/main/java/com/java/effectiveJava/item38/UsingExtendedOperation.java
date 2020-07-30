package com.java.effectiveJava.item38;

import java.util.Collection;

public class UsingExtendedOperation {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        test(ExtendedOperation.class, x, y);
    }

    // 첫번째 방법. 한정적 타입 토큰 이용하기
    private static <T extends Enum<T> & Operation> void test(
            Class<T> opEnumType, double x, double y){

        for(Operation op : opEnumType.getEnumConstants()){
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }

    // 두번째 방법. 한정적 와일드카드 타입 이용하기
    private static void test2(
            Collection<? extends Operation> opSet, double x, double y){

        for(Operation op : opSet){
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }
}
