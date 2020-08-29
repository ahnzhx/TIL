package com.java.effectiveJava.classAndInterface.item13;

public class Sub extends Sup {
    String temp;
    @Override
    public void overrideMe() {
        System.out.println("sub method");
        System.out.println(temp);
        type = "sub";
    }

    @Override
    public Sub clone() {
        Sub clone = (Sub) super.clone();
        clone.temp = "temp";
        return clone;
    }

}
