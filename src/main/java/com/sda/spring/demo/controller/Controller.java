package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Controller {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/", method =RequestMethod.GET)
    public String hello(){
        return "Hello world";
    }
    @RequestMapping(value = "/listOfNumbers", method = RequestMethod.GET)
    public List<Integer> numbers(){
        List<Integer>list = new ArrayList<>();
        for (int i = 1; i<10;i++){
            list.add(i);
        }
        return list;
    }
    @RequestMapping(value = "/sentence", method = RequestMethod.GET)
    public String sentence(){
        String[] words = {"oko", "ucho", "nogę", "serce", "głowę", "włos", "palec", "usta"};
        Random random = new Random();
        int number = random.nextInt(words.length);
        String word = "Masz " + words[number] + " z kamienia!";
        return word;
    }
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public List<Book> showBookList(){
        return bookRepository.findAll();
    }

}
