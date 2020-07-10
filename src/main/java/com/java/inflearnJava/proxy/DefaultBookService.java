package com.java.inflearnJava.proxy;

public class DefaultBookService implements BookService {

    @Override
    public void rent(Book book) {
        System.out.println("rent:" + book.getName());
    }
}
