package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> listAll(){
        return (List<Category>) repository.findAll();
    }
    public void save(Category category){
        repository.save(category);
    }
    public Category get(Long Category_id){
        return repository.findById(Category_id).get();
    }
    public void delete(Long Category_id){
        repository.deleteById(Category_id);
    }
}
