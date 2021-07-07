package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/product")
    public List<Product> list(){
        return service.listAll();
    }
    @GetMapping("/product/{Product_id}")
    public ResponseEntity<Product> get(@PathVariable Long Product_id){
        try {
            Product product=service.get(Product_id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/product")
    public void  add(@RequestBody Product product){
        service.save(product);
    }
    @PutMapping ("/admin/{Product_id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long Product_id){
        try {
            Product existProduct=service.get(Product_id);
            service.save(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/admin/{Product_id}")
    public String delete(@PathVariable  (value = "Product_id") Long Product_id){
        service.delete(Product_id);
        return "Delete Sucessfully id ="+Product_id;
    }
}
