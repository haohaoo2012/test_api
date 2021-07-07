package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public List<User> listAll(){
        return (List<User>) repository.findAll();
    }
    public void save(User user){
        repository.save(user);
    }
    public User get(Long User_id){
        return repository.findById(User_id).get();
    }
    public void delete(Long User_id){
        repository.deleteById(User_id);
    }
}
