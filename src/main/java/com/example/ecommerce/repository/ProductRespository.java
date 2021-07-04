package com.example.ecommerce.repository;
import  com.example.ecommerce.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRespository extends CrudRepository<Product,Long> {
}
