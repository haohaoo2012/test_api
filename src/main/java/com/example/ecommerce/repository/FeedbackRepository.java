package com.example.ecommerce.repository;
import com.example.ecommerce.model.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedback,Long> {
}
