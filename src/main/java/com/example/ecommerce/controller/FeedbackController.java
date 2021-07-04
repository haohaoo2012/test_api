package com.example.ecommerce.controller;

import com.example.ecommerce.model.Feedback;
import com.example.ecommerce.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class FeedbackController  {
    @Autowired
    private FeedbackService service;

    @GetMapping("/feedback")
    public List<Feedback> list() {
        return service.listAll();
    }

    @GetMapping("/feedback/{Feedback_id}")
    public ResponseEntity<Feedback> get(@PathVariable Long Feedback_id) {
        try {
            Feedback feedback = service.get(Feedback_id);
            return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Feedback>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/feedback")
    public void  add(@RequestBody Feedback feedback) {
        service.save(feedback);
    }


    @PutMapping("/feedback/{Feedback_id}")
    public ResponseEntity<?> update(@RequestBody Feedback feedback, @PathVariable Long Feedback_id) {
        try {
            Feedback existFeedback = service.get(Feedback_id);
            service.save(feedback);
            return new ResponseEntity<>(feedback, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/feedback/{Feedback_id}")
    public String delete(@PathVariable(value = "Feedback_id") Long Feedback_id) {
        service.delete(Feedback_id);
        return "Delete Sucessfully id =" + Feedback_id;
    }
}
