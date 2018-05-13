package com.sda.spring.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Setter
@NoArgsConstructor
@Entity
public class Author {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    private String name;
    @Getter
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

}
