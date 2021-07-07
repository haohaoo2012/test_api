package com.example.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="product_img")
public class Product_img implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "img_id")
    private Long img_id;
    @Column(name = "img_link")
    private String img_link;
    @Column(name = "product_id")
    private Long product_id;

    public Long getImg_id() {
        return img_id;
    }

    public void setImg_id(Long img_id) {
        this.img_id = img_id;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }


    @Override
    public String toString() {
        return "product_img{" +
                "img_id=" + img_id +
                ", img_link='" + img_link + '\'' +
                ", product_id=" + product_id +
                '}';
    }
}
