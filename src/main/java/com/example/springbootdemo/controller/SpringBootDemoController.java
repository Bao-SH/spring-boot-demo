package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Book;
import com.example.springbootdemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class SpringBootDemoController {
  private final BookService bookService;

  @GetMapping("/hello")
  public final ResponseEntity<String> hello() {
    return ResponseEntity.status(HttpStatus.OK).body("hello");
  }

  @PostMapping("/book")
  public final ResponseEntity<String> createBook(@RequestBody final Book book) {

    var result = bookService.createBook(book);
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }
}
