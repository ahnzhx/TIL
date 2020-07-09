package com.java.inflearnJava.di;


import com.java.inflearnJava.reflection.Book;

public class BookService {

    @Inject
    BookRepository bookRepository;

    public void rent(String book){
        System.out.println("rent: " +book.getBytes());

    }
}
