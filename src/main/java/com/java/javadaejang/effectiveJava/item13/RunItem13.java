package com.java.javadaejang.effectiveJava.item13;

public class RunItem13 {
    public static void main(String[] args) throws CloneNotSupportedException {
//        Item13 item13 = new Item13();
//        System.out.println("original name: " + item13.getName());
//        Item13 item13Cloned = (Item13) item13.clone();
//        System.out.println("cloned name: "+ item13Cloned.getName());

        Stack stack = new Stack();
        // stack이 아니고 item13이 반환됨.
        System.out.println(stack.clone().getClass());

    }
}
