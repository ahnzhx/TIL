package com.java.rxJava;

import io.reactivex.Flowable;

public class HelloWorld {
    public static void main(String[] args) {
        Flowable.just("hello world").subscribe(System.out::println);

    }
}
