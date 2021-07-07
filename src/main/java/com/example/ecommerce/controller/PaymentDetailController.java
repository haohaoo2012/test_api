package com.example.ecommerce.controller;

import com.example.ecommerce.model.Payment_Details;
import com.example.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PaymentDetailController {
    @Autowired
    private PaymentService service;

    @GetMapping("/payment")
    public List<Payment_Details> list(){
        return service.listAll();
    }
    @GetMapping("/Payment_Details/{Pay_id}")
    public ResponseEntity<Payment_Details> get(@PathVariable Long Pay_id){
        try {
            Payment_Details Payment_Details=service.get(Pay_id);
            return new ResponseEntity<Payment_Details>(Payment_Details, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<Payment_Details>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/payment")
    public void  add(@RequestBody Payment_Details Payment_Details){
        service.save(Payment_Details);
    }
    @PutMapping ("/Payment_Details/{Pay_id}")
    public ResponseEntity<?> update(@RequestBody Payment_Details Payment_Details, @PathVariable Long Pay_id){
        try {
            Payment_Details existPayment_Details=service.get(Pay_id);
            service.save(Payment_Details);
            return new ResponseEntity<>(Payment_Details, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/Payment_Details/{Pay_id}")
    public String delete(@PathVariable  (value = "Pay_id") Long Pay_id){
        service.delete(Pay_id);
        return "Delete Sucessfully id ="+Pay_id;
    }
}

