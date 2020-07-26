package com.java.effectiveJava.item34;

public enum Operation {
    PLUS("+"){
        public double apply(double x, double y){return x + y;}
    },
    MINUS("-"){
        public double apply(double x, double y){return x - y;}
    },
    MULTIPLY("*"){
        public double apply(double x, double y){return x * y;}
    },
    DIVIDE("/"){
        public double apply(double x, double y){return x / y;}
    };

    private final String symbol;

    Operation(String symbol){
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);
}

enum Ensemble{
    SOLO(1), DUET(2), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;
    Ensemble(int size){ this.numberOfMusicians = size; }
    public int numberOfMusicians(){ return numberOfMusicians; }

}