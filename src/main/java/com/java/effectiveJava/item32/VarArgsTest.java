package com.java.effectiveJava.item32;

import java.util.List;

public class VarArgsTest {
    static void dangerous(List<String>... stringLists){
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;
        String s= stringLists[0].get(0); // 왜 얘가 int로 변하지?

    }

    public static void main(String[] args) {
        List<String> stringList1 = List.of("ff", "ggg");
        List<String> stringList2 = List.of("qe", "www");

        dangerous(stringList1, stringList2);

    }
}
