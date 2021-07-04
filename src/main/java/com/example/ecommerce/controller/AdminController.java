package com.example.ecommerce.controller;

import com.example.ecommerce.model.Admin;
import com.example.ecommerce.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class AdminController {
    @Autowired
    private AdminService service;

    @GetMapping("/admin")
    public List<Admin> list(){
        return service.listAll();
    }
    @GetMapping("/admin/{Ad_id}")
    public ResponseEntity<Admin> get(@PathVariable Long Ad_id){
        try {
            Admin admin=service.get(Ad_id);
            return new ResponseEntity<Admin>(admin, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/admin")
    public void  add(@RequestBody Admin admin){
        service.save(admin);
    }
    @PutMapping ("/admin/{Ad_id}")
    public ResponseEntity<?> update(@RequestBody Admin admin, @PathVariable Long Ad_id){
        try {
            Admin existAdmin=service.get(Ad_id);
            service.save(admin);
            return new ResponseEntity<>(admin, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/admin/{Ad_id}")
    public String delete(@PathVariable  (value = "Ad_id") Long Ad_id){
        service.delete(Ad_id);
        return "Delete Sucessfully id ="+Ad_id;
    }
}
