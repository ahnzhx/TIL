package com.java.inflearnJava.reflection;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Book> bookClass = Book.class;

        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        Class.forName("com.java.inflearnJava.reflection.Book");

        //getFields는 public한 것만 가져온다.
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        //private, protected, public 모두 가져온다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);


        Arrays.stream(bookClass.getDeclaredFields()).forEach(f->{
            try {
                f.setAccessible(true);
                System.out.printf("%s %s \n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);

        Arrays.stream(Book.class.getDeclaredFields()).forEach(f->{
            Arrays.stream(f.getAnnotations()).forEach(a->{
                if(a instanceof MyAnnotation){
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println(myAnnotation.value());
                    System.out.println(myAnnotation.number());
                }
            });
        });

    }
}
