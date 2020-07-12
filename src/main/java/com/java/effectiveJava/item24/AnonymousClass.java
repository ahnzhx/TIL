package com.java.effectiveJava.item24;

public class AnonymousClass {

    public void anonymousClassTest(){

        final int finalVariable = 1;
        int normalVariable = 1;
        String normalString = "test";
        final String finalString = "test22";


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(finalVariable);
                System.out.println(normalVariable);
                System.out.println(normalString);
            }
        });

    }

    public void LocalInnerClass(){
        class LocalInnerClassTest{
            public void hello(){
                System.out.println("hello~");
            }
        }

        LocalInnerClassTest lic = new LocalInnerClassTest();
        lic.hello();
    }
}
