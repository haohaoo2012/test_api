package com.example.ecommerce.controller;

import com.example.ecommerce.model.Order_Details;
import com.example.ecommerce.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class Order_DetailController {
    @Autowired
    private OrderDetailService service;

    @GetMapping("/orderdetails")
    public List<Order_Details> list() {
        return service.listAll();
    }

    @GetMapping("/orderdetails/{Order_detail_id}")
    public ResponseEntity<Order_Details> get(@PathVariable Long Order_detail_id) {
        try {
            Order_Details order_details = service.get(Order_detail_id);
            return new ResponseEntity<Order_Details>(order_details, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Order_Details>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/orderdetails")
    public void  add(@RequestBody Order_Details order_details) {
        service.save(order_details);
    }


    @PutMapping("/orderdetails/{Order_detail_id}")
    public ResponseEntity<?> update(@RequestBody Order_Details order_details, @PathVariable Long Order_detail_id) {
        try {
            Order_Details existOrderdetails = service.get(Order_detail_id);
            service.save(order_details);
            return new ResponseEntity<>(order_details, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/orderdetails/{Order_detail_id}")
    public String delete(@PathVariable(value = "Order_detail_id") Long Order_detail_id) {
        service.delete(Order_detail_id);
        return "Delete Sucessfully id =" + Order_detail_id;
    }
}
