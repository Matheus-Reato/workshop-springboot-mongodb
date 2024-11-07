package com.matheusreato.workshopmongo.services;

import com.matheusreato.workshopmongo.domain.User;
import com.matheusreato.workshopmongo.dto.UserDTO;
import com.matheusreato.workshopmongo.repositories.UserRepository;
import com.matheusreato.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;


    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj){
        User newObj = repo.findById(obj.getId()).get();
        updateData(newObj, obj);

        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
