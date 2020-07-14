package com.java.inflearnJava.proxy;

public class BookServiceClass {
    void rent(Book book){
        System.out.println(book.getName());
    }

    void returnBook(Book book){
        System.out.println("returned Book : "+ book.getName());
    }
}
