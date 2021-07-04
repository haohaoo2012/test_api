package com.example.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
@Entity
@Table(name="orders")

public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long order_id;
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "order_address")
    private String order_address;
    @Column(name = "order_email")
    private String order_email;
    @Column(name = "order_date")
    private Timestamp order_date;
    @Column(name = "order_status")
    private String order_status;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public String getOrder_email() {
        return order_email;
    }

    public void setOrder_email(String order_email) {
        this.order_email = order_email;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "OrderController{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", order_address='" + order_address + '\'' +
                ", order_email='" + order_email + '\'' +
                ", order_date=" + order_date +
                ", order_status='" + order_status + '\'' +
                '}';
    }
}