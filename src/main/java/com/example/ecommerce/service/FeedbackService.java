package com.example.ecommerce.service;

import com.example.ecommerce.model.Feedback;
import com.example.ecommerce.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public List<Feedback> listAll(){
        return (List<Feedback>) repository.findAll();
    }
    public void save(Feedback feedback){
        repository.save(feedback);
    }
    public Feedback get(Long Feedback_id){
        return repository.findById(Feedback_id).get();
    }
    public void delete(Long Feedback_id){
        repository.deleteById(Feedback_id);
    }
}
