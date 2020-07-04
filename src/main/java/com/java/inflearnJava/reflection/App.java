package com.java.inflearnJava.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class<Book> bookClass = Book.class;

        Book book = new Book("B");
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

        
        Class<?> bookClass2 = Class.forName("com.java.inflearnJava.reflection.Book");
        // getConstructor의 parameter에 nulld을 주면 기본 생성자를 만든다. 
        Constructor<?> constructor = bookClass.getConstructor(null);  // String.class도 가능하다.
        Book book2 = (Book) constructor.newInstance();
        
        Field a = Book.class.getDeclaredField("A");
        System.out.println(a.get(null));
        a.set(null, "AAAAA");
        System.out.println(a.get(null));
        
        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true); // private에 접근 가능하도록 한다. 
        System.out.println(b.get(book)); // book 안에 있는 field B를 가져오는 것이다.
        b.set(book, "BBBBB"); // book 필드 안에 있는 field B의 값을 "BBBBB"로 바꾼다. 
        
        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book);
        
        Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) sum.invoke(book, 1, 2);
        System.out.println(invoke);
    }
}
