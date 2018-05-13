package com.sda.spring.demo.service;

import com.sda.spring.demo.model.User;
import com.sda.spring.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User save(User user){
        return userRepository.save(user);
    }

    public Optional<User> getCategoryById(Long id){
        Optional<User> user =  userRepository.findById(id);
        return user;
    }
}
