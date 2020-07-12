package com.java.effectiveJava.item24;

public class MakingStaticMemberClass {
    public void thisTest(){
        this.nonStaticMethod();
        System.out.println("testing this");
    }

    public void nonStaticMethod(){
        System.out.println("this is integer");
    }


    public static void staticMethodTest(){
        System.out.println("바깥 클래스에서 참조가 가능할까?");
    }

}