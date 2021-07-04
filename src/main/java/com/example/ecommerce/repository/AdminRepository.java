package com.example.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import  com.example.ecommerce.model.Admin;
public interface AdminRepository extends CrudRepository<Admin,Long> {
}
