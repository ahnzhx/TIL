package com.java.effectiveJava.generic.item32;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;

public class BoundedWildCardExample {
    @Test
    public void 생산자테스트(){
        Stack<Number> stack = new Stack<>();
        List<Integer> integerList = Arrays.asList(1,2,3);

        stack.addAll(integerList);

        for(int i = stack.size() - 1; !stack.isEmpty(); i--) {
            assertEquals(integerList.get(i), (Integer) stack.pop());
        }
    }

}