package com.java.effectiveJava.item42;

import java.util.HashMap;
import java.util.Map;

public class MethodReferenceExample {
    Map<Integer, Integer> map = new HashMap<>();
    public void multisetExample(){
        map.merge(key, 1, (count, incr) -> count+ incr);
    }
}
