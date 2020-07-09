package com.java.inflearnJava.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookService implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public void rent(Book book) {

    }
}
