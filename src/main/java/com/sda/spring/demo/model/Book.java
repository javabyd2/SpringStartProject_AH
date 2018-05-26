package com.sda.spring.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private int isbn;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(joinColumns =
    @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "author_id",
                    referencedColumnName = "id"))
    private Set<Author> authors;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Publisher publisher;

    public Book(String title, Set<Author> authors, Category category, Publisher publisher){
        this.title=title;
        this.authors=authors;
        this.category = category;
        this.publisher = publisher;
    }

}
