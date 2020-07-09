package com.java.inflearnJava.reflection;


public class Book {
    public static String A = "A";
    
    private String B = "B";

    public static String getA() {
        return A;
    }

    public String getB() {
        return B;
    }

    public Book(String b){
        B = b;
    }
    public Book(){

    }
    
    public void c(){
        System.out.println("C");
    }
    
    public int sum(int left, int right){
        return left+right;
    }
         
}
