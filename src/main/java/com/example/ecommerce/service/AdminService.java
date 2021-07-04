package com.example.ecommerce.service;

import com.example.ecommerce.model.Admin;
import com.example.ecommerce.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private final AdminRepository repository;

    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    public List<Admin> listAll(){
         return (List<Admin>) repository.findAll();
    }
    public void save(Admin admin){
        repository.save(admin);
    }
    public Admin get(Long Ad_id){
       return repository.findById(Ad_id).get();
    }
    public void delete(Long Ad_id){
        repository.deleteById(Ad_id);
    }
}
