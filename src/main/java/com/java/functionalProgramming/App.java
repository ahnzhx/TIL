package com.java.functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class App {

    private static List<Student> studentList = Arrays.asList(
            new Student("소현", "이펙티브 자바", 3, 60),
            new Student("태훈", "함수형 프로그래밍", 1, 98)
    );

    public static void printString(Function<Student, String> function){
        for (Student student : studentList)
            System.out.println(function.apply(student) + " // ");
    }

    public static void printInt(ToIntFunction<Student> function){
        for(Student student: studentList)
            System.out.println(function.applyAsInt(student)+" && ");

    }

    public static void printDouble(ToDoubleBiFunction<Integer, Double> function){
        for(Student student : studentList){
            System.out.println(function.applyAsDouble(student.getCredit(), 4.0));
        }


    }

    public static void functionExample(){
        Function<Integer, Integer> multiply = v -> v * 2;
        Function<Integer, Integer> add = v -> v + 3;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add); // (v+3)*2
        Integer result = addThenMultiply.apply(3);
        System.out.println(result);

        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add); // (v*2)+3
        Integer result2 = multiplyThenAdd.apply(3);
        System.out.println(result2);
    }


    public static void main(String[] args) {
        //printString(t -> t.getName());
        //printDouble(t -> t.intValue(), 3);
        functionExample();
    }
}
