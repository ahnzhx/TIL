package com.java.effectiveJava.item45;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.TWO;

public class MersennePrime {
    static Stream<BigInteger> primes(){
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
    public static void main(String[] args) {
//        primes().map(p -> TWO.pow(p.intValueExact()).substract(ONE));
//        .filter
    }
}
