package com.sda.spring.demo.service;

import com.sda.spring.demo.model.Role;
import com.sda.spring.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRolesList(){
        return roleRepository.findAll();
    }
    public Role save(Role role){
        return roleRepository.save(role);
    }
    public Optional<Role> getRoleById(Long id){
        Optional<Role> role = roleRepository.findById(id);
        return role;
    }
}
