package com.sda.spring.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private int isbn;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns =
    @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "author_id",
                    referencedColumnName = "id"))
    private Set<Author> authors;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    public Book(String title, Set<Author> authors, Category category){
        this.title=title;
        this.authors=authors;
        this.category = category;
    }

}
