package com.example.ecommerce.service;


import com.example.ecommerce.model.Order;
import com.example.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
    public List<Order> listAll(){
        return (List<Order>) repository.findAll();
    }
    public void save(Order order){
        repository.save(order);
    }
    public Order get(Long Order_id){
        return repository.findById(Order_id).get();
    }
    public void delete(Long Order_id){
        repository.deleteById(Order_id);
    }
}
