package com.example.ecommerce.repository;
import com.example.ecommerce.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
