package com.example.ecommerce.service;

import com.example.ecommerce.model.Product_img;
import com.example.ecommerce.repository.Product_imgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product_imgService {
    @Autowired
    private final Product_imgRepository repository;

    public Product_imgService(Product_imgRepository repository) {
        this.repository = repository;
    }

    public List<Product_img> listAll(){
        return (List<Product_img>) repository.findAll();
    }
    public void save(Product_img product_img){
        repository.save(product_img);
    }
    public Product_img get(Long img_id){
        return repository.findById(img_id).get();
    }
    public void delete(Long img_id){
        repository.deleteById(img_id);
    }
}
