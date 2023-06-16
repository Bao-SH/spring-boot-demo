package com.example.springbootdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class SpringBootDemoController {

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.status(HttpStatus.OK).body("hello");
    }

    @PostMapping("/book")
    public ResponseEntity<String> createBook() {
        return ResponseEntity.status(HttpStatus.OK).body("book");
    }
}
