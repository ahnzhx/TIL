package com.java.javadaejang.inflearnJava;

import java.io.IOException;

public class Masulsa {
    public static void main(String[] args) throws IOException {
//        new ByteBuddy().redefine(Moja.class)
//                       .method(named("pullOut"))
//                       .intercept(FixedValue.value("Rabbit!"))
//        .make().saveIn(new File("/Users/sohyunahn/Downloads/javadaejang/target/classes/"));
        System.out.println(new Moja().pullOut());
    }
}
