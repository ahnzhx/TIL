package com.java.effectiveJava.method;

import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class item54 {
    public List<Cheese> getCheese(){
        return new ArrayList<>(cheeseInStock);
    }
    public Cheese[] getCheese(){
        return cheesesInStock.toArray(new Cheese[0]);
    }

    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

    public Cheese[] getCheese(){
        return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }

    class ThreadLocal{
        private ThreadLocal(){};

        public static class Key{
            Key(){}
        }
        public static Key getKey(){
            return new Key();
        }
    }

    public void test(){
        // 좋은 예. 인터페이스를 타입으로 사용했다.
        Set<Integer> tSet = new LinkedHashSet<>();
        // 나쁜 예. 클래스를 타입으로 사용했다.
        LinkedHashSet<Integer> tSet = new LinkedHashSet<>();
    }

}
