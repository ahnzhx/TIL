package com.java.inflearnJava.proxy;

public class BookServiceProxy implements BookService {

    BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("before rent,,,,");
        bookService.rent(book);
        System.out.println("after rent,,,,");
    }
}
