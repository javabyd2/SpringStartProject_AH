package com.sda.spring.demo.service;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }
    public Author save(Author author){
        return authorRepository.save(author);
    }

    public Optional<Author> getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author;
    }
}
