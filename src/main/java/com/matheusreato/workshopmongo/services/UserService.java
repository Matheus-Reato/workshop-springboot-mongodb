package com.matheusreato.workshopmongo.services;

import com.matheusreato.workshopmongo.domain.User;
import com.matheusreato.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;


    public List<User> findAll(){
        return repo.findAll();
    }

}
