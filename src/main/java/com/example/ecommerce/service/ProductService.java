package com.example.ecommerce.service;


import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRespository repository;
    public ProductService(ProductRespository repository) {
        this.repository = repository;
    }
    public List<Product> listAll(){
        return (List<Product>) repository.findAll();
    }
    public void save(Product product){
        repository.save(product);
    }
    public Product get(Long Product_id){
        return repository.findById(Product_id).get();
    }
    public void delete(Long Product_id){
        repository.deleteById(Product_id);
    }
}
