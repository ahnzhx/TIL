package com.java.effectiveJava.generic.item32;

import java.util.List;

public class VarArgsTest {
    static void dangerous(List<String>... stringLists){
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;
        String s= stringLists[0].get(0); // intList와 같은 주소를 바라보고 있기 때문에 생기는 오류

    }

    public static void main(String[] args) {
        List<String> stringList1 = List.of("ff", "ggg");
        List<String> stringList2 = List.of("qe", "www");

        dangerous(stringList1, stringList2);

    }

}
