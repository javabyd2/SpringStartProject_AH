package com.sda.spring.demo.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id){
        super("Nie mogę znaleźć autora" + id); //super wykonuje konstruktor klasy dziedziczącej czyli Runtime Exp.
    }
}
