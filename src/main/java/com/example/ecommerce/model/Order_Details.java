package com.example.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="order_details")
public class Order_Details implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long order_detail_id;
    @Column(name = "order_id")
    private Long order_id;
    @Column(name = "product_id")
    private Long product_id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "product_quantity")
    private Long product_quantity;
    @Column(name = "account_id")
    private Long account_id;
    @Column(name = "pay_id")
    private Long pay_id;

    public Long getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(Long order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Long getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(Long product_quantity) {
        this.product_quantity = product_quantity;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Long getPay_id() {
        return pay_id;
    }

    public void setPay_id(Long pay_id) {
        this.pay_id = pay_id;
    }

    @Override
    public String toString() {
        return "Order_Detail{" +
                "order_detail_id=" + order_detail_id +
                ", order_id=" + order_id +
                ", product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_quantity=" + product_quantity +
                ", account_id=" + account_id +
                ", pay_id=" + pay_id +
                '}';
    }
}
