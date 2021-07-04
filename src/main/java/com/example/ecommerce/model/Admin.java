package com.example.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="admin")

public class Admin  implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ad_id")
    private Long ad_id;
    @Column(name = "ad_name")
    private String ad_name;
    @Column(name = "ad_username")
    private String ad_username;
    @Column(name = "ad_password")
    private String ad_password;


    public Long getAd_id() {
        return ad_id;
    }

    public void setAd_id(Long ad_id) {
        this.ad_id = ad_id;
    }

    public String getAd_name() {
        return ad_name;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public String getAd_username() {
        return ad_username;
    }

    public void setAd_username(String ad_username) {
        this.ad_username = ad_username;
    }

    public String getAd_password() {
        return ad_password;
    }

    public void setAd_password(String ad_password) {
        this.ad_password = ad_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ad_id=" + ad_id +
                ", ad_name='" + ad_name + '\'' +
                ", ad_username='" + ad_username + '\'' +
                ", ad_password='" + ad_password + '\'' +
                '}';
    }
}
