package com.sda.spring.demo;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired//wstrzykuje ten obiekt do kontekstu aplikacji
    public BookRepository bookRepository;

    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
	public AuthorRepository authorRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Author author = new Author("Alan","Kift");
//
//		Category cat = new Category("eukacyjna");
//		Category cat1 = new Category("poradnik");
//
//		Set<Author> authors = new HashSet<>();
//		authors.add(author);
//		Book book = new Book("Java. Rusz głową", authors,cat);
//		bookRepository.save(book);
//		authors.clear();

//		Author author1 = new Author("John", "Spraul");
//		authors.add(author1);
//		Category category = categoryRepository.findByName("eukacyjna");
//		book = new Book("Jak działa oprogramowanie", authors,category);
//		bookRepository.save(book);


	}
}
