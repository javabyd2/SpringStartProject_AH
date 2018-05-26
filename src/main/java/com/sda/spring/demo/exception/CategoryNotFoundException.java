package com.sda.spring.demo.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Long id){
        super("Nie mogę znaleźć kategorii" + id); //super wykonuje konstruktor klasy dziedziczącej czyli Runtime Exp.
    }
}
