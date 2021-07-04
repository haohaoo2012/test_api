package com.example.ecommerce.controller;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/category")
    public List<Category> list() {
        return service.listAll();
    }

    @GetMapping("/category/{Category_id}")
    public ResponseEntity<Category> get(@PathVariable Long Category_id) {
        try {
            Category category = service.get(Category_id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/category")
    public void  add(@RequestBody Category category) {
        service.save(category);
    }


    @PutMapping("/category/{Category_id}")
    public ResponseEntity<?> update(@RequestBody Category category, @PathVariable Long Category_id) {
        try {
            Category existCategory = service.get(Category_id);
            service.save(category);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/category/{Category_id}")
    public String delete(@PathVariable(value = "Category_id") Long Category_id) {
        service.delete(Category_id);
        return "Delete Sucessfully id =" + Category_id;
    }
}