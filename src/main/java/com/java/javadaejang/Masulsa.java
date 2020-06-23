package com.java.javadaejang;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {
    public static void main(String[] args) throws IOException {
//        new ByteBuddy().redefine(Moja.class)
//                       .method(named("pullOut"))
//                       .intercept(FixedValue.value("Rabbit!"))
//        .make().saveIn(new File("/Users/sohyunahn/Downloads/javadaejang/target/classes/"));
        System.out.println(new Moja().pullOut());
    }
}
