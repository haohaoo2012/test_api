package com.example.ecommerce.service;


import com.example.ecommerce.model.Payment_Details;
import com.example.ecommerce.repository.Payment_detailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private final Payment_detailRepository repository;
    public PaymentService(Payment_detailRepository repository) {
        this.repository = repository;
    }
    public List<Payment_Details> listAll(){
        return (List<Payment_Details>) repository.findAll();
    }
    public void save(Payment_Details payment_details){
        repository.save(payment_details);
    }
    public Payment_Details get(Long Pay_id){
        return repository.findById(Pay_id).get();
    }
    public void delete(Long Pay_id){
        repository.deleteById(Pay_id);
    }
}
