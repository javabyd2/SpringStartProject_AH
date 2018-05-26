package com.sda.spring.demo.service;

import com.sda.spring.demo.exception.PublisherNotFoundException;
import com.sda.spring.demo.model.Publisher;
import com.sda.spring.demo.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getPublishers(){
        return publisherRepository.findAll();
    }
    public Publisher save(Publisher publisher){
        return publisherRepository.save(publisher);
    }
    public Publisher getPublisherById(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(
                ()-> new PublisherNotFoundException(id)
        );
        return publisher;
    }
}
