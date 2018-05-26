package com.sda.spring.demo.dto;

import com.sda.spring.demo.model.Role;
import lombok.Data;

@Data
public class UserProperties {
    private Long id;

    private String userName;

    private String lastName;

    private String nick;

    private String address;

    private String city;

    private String postalCode;

    private Long telephoneNumber;

    private Role role;

}
