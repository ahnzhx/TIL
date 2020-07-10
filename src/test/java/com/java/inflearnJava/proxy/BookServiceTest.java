package com.java.inflearnJava.proxy;

import org.junit.jupiter.api.Test;


public class BookServiceTest {

    BookService bookService = new BookServiceProxy(new DefaultBookService());

    @Test
    public void di(){
        Book book = new Book();
        book.setName("Spring");
        bookService.rent(book);
    }
}