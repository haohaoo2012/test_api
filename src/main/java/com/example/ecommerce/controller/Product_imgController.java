package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product_img;
import com.example.ecommerce.service.Product_imgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
public class Product_imgController {
    @Autowired
    private Product_imgService service;

    @GetMapping("/product_img")
    public List<Product_img> list(){
        return service.listAll();
    }
    @GetMapping("/product_img/{img_id}")
    public ResponseEntity<Product_img> get(@PathVariable Long img_id){
        try {
            Product_img product_img=service.get(img_id);
            return new ResponseEntity<Product_img>(product_img, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<Product_img>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(value = "/product_img", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product_img add(@RequestBody Product_img product_img){
       this.service.save(product_img);
        return product_img;
    }
    @PutMapping("/product_img/{img_id}")
    public ResponseEntity<?> update(@RequestBody Product_img product_img, @PathVariable Long img_id){
        try {
            Product_img existproduct_img=service.get(img_id);
            service.save(product_img);
            return new ResponseEntity<>(product_img, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/product_img/{img_id}")
    public String delete(@PathVariable  (value = "img_id") Long img_id){
        service.delete(img_id);
        return "Delete Sucessfully id ="+img_id;
    }
}
