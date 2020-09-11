package com.java.effectiveJava.concurrent;

import junit.framework.TestCase;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolExampleTest extends TestCase {
    public void test(){
        ForkJoinPoolExample myForkJoin = new ForkJoinPoolExample(24);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(myForkJoin);
    }

}