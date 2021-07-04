package com.example.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="feedback")
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedback_id;
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "order_id")
    private Long order_id;
    @Column(name = "feedback_content")
    private String feedback_content;
    @Column(name = "feedback_time")
    private Timestamp feedback_time;

    public Long getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(Long feedback_id) {
        this.feedback_id = feedback_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getFeedback_content() {
        return feedback_content;
    }

    public void setFeedback_content(String feedback_content) {
        this.feedback_content = feedback_content;
    }

    public Timestamp getFeedback_time() {
        return feedback_time;
    }

    public void setFeedback_time(Timestamp feedback_time) {
        this.feedback_time = feedback_time;
    }

    @Override
    public String toString() {
        return "FeedbackController{" +
                "feedback_id=" + feedback_id +
                ", user_id=" + user_id +
                ", order_id=" + order_id +
                ", feedback_content='" + feedback_content + '\'' +
                ", feedback_time=" + feedback_time +
                '}';
    }
}