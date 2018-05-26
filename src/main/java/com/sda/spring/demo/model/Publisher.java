package com.sda.spring.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Setter
@Entity
public class Publisher {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    private String name;
    @Getter
    private String address;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;
}
