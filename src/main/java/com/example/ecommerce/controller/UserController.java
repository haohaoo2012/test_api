package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/user")
    public List<User> list(){
        return service.listAll();
    }
    @GetMapping("/user/{User_id}")
    public ResponseEntity<User> get(@PathVariable Long User_id){
        try {
            User User=service.get(User_id);
            return new ResponseEntity<User>(User, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/user")
    public void  add(@RequestBody User User){
        service.save(User);
    }
    @PutMapping ("/user/{User_id}")
    public ResponseEntity<?> update(@RequestBody User User, @PathVariable Long User_id){
        try {
            User existUser=service.get(User_id);
            service.save(User);
            return new ResponseEntity<>(User, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/User/{User_id}")
    public String delete(@PathVariable  (value = "User_id") Long User_id){
        service.delete(User_id);
        return "Delete Sucessfully id ="+User_id;
    }
}
