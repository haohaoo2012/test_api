package com.example.ecommerce.service;


import com.example.ecommerce.model.Order_Details;
import com.example.ecommerce.repository.Order_detailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private final Order_detailRepository repository;

    public OrderDetailService(Order_detailRepository repository) {
        this.repository = repository;
    }

    public List<Order_Details> listAll(){
        return (List<Order_Details>) repository.findAll();
    }
    public void save(Order_Details order_details){
        repository.save(order_details);
    }
    public Order_Details get(Long Order_detail_id){
        return repository.findById(Order_detail_id).get();
    }
    public void delete(Long Order_detail_id){
        repository.deleteById(Order_detail_id);
    }
}
