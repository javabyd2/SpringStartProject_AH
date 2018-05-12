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

		Author author = new Author("Alan","Kift");
//		authorRepository.save(author);

		Category cat = new Category("eukacyjna");
		Category cat1 = new Category("poradnik");
//		categoryRepository.save(cat);
//		categoryRepository.save(cat1);
		Set<Author> authors = new HashSet<>();
		Book book = new Book("Java. Rusz głową");
		book.setCategory(cat);
		authors.add(author);
		book.setAuthors(authors);
		bookRepository.save(book);
	}
}
