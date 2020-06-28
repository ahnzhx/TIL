package com.java.javadaejang.effectiveJava.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack extends Item13{

    private Object[] elements;
    private int size =0;
    private static final int DEFAULT_INITIAL_CAPACITY=16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;

    }

    // 원소를 위한 공간을 적어도 하나 이상 확보한다.
    private void ensureCapacity() {
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public Object pop(){
        if(size ==0){
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    //TODO:    설명추가
    @Override
    protected Stack clone() throws CloneNotSupportedException {
        Stack result = (Stack) super.clone();
        result.elements = elements.clone();
        return result;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone() ;
//    }
}
