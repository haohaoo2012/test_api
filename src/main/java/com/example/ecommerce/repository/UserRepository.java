package com.example.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import  com.example.ecommerce.model.User;
public interface UserRepository extends CrudRepository<User,Long> {
}
