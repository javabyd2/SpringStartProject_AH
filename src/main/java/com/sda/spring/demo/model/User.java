package com.sda.spring.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String lastName;

    private String password;

    private String nick;

    private String address;

    private String city;

    private String postalCode;

    private Long telephoneNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Role role;

    public User(String name, String surname, String pass){
        this.userName = name;
        this.lastName= surname;
        this.password = pass;
    }

}
