package com.example.springbootdemo.entity;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    private final UUID id;
    private final String name;
    private String author;
    private Date publishTime;
    private Integer number;
}
