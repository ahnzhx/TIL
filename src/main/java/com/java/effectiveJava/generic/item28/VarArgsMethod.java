package com.java.effectiveJava.generic.item28;

public class VarArgsMethod {
    public static int sum(int... sum){
        int result =0;
        for(int i : sum){
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        VarArgsMethod.sum(1,2,3);
        VarArgsMethod.sum(new int[]{1,2,3});
    }
}
