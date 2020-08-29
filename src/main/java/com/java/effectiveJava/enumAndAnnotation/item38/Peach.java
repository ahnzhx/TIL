package com.java.effectiveJava.enumAndAnnotation.item38;

/**
 * 타입 안전 열거 패턴의 예
*/
public class Peach {
    private final String type;

    public Peach(String type) {
        this.type = type;
    }

    public static final Peach CRACKER = new Peach("Peach Cracker");
    public static final Peach JAM = new Peach("Peach Jam");
}

