package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public String createBook(Book book) {
        return "Book %s is created.".formatted(book);
    }
}
