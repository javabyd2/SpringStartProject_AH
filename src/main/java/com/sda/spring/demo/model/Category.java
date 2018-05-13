package com.sda.spring.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Setter
@Entity
public class Category {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_ID")
    private Long id;

    @Getter
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Book> booksList;

    public Category(String name){
        this.name=name;
    }

}
