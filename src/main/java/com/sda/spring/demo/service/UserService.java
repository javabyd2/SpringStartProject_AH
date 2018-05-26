package com.sda.spring.demo.service;

import com.sda.spring.demo.dto.UserDTO;
import com.sda.spring.demo.dto.UserProperties;
import com.sda.spring.demo.model.User;
import com.sda.spring.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserProperties> getUsers(){
        List<UserProperties> listFromUserProperties = new ArrayList<>();

        List<User> users = userRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        for (User user:users) {
            UserProperties userProperties = modelMapper.map(user,UserProperties.class);
            listFromUserProperties.add(userProperties);
        }
        return listFromUserProperties;
    }
    public User save(User user){
        return userRepository.save(user);
    }

    public UserDTO getUserById(Long id){
        Optional<User> user =  userRepository.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user.get(), UserDTO.class);
        return userDTO;
    }
}
