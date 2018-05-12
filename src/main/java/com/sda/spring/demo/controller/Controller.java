package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
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
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;

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
    public List<Book> showBooksList(){
        return bookService.getBooks();
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> showAuthorsList(){
        return authorService.getAuthors();
    }
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> showCategoriesList(){
        return categoryService.getCategories();
    }
}
