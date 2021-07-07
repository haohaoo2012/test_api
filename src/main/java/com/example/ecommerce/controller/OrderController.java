package com.example.ecommerce.controller;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/order")
    public List<Order> list(){
        return service.listAll();
    }
    @GetMapping("/order/{Order_id}")
    public ResponseEntity<Order> get(@PathVariable Long Order_id){
        try {
            Order admin=service.get(Order_id);
            return new ResponseEntity<Order>(admin, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/order")
    public void  add(@RequestBody Order order){
        service.save(order);
    }
    @PutMapping ("/order/{Order_id}")
    public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Long Order_id){
        try {
            Order existOrder=service.get(Order_id);
            service.save(order);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/order/{Order_id}")
    public String delete(@PathVariable  (value = "Order_id") Long Order_id){
        service.delete(Order_id);
        return "Delete Sucessfully id ="+Order_id;
    }
}
