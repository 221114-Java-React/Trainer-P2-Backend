package com.revature.yolp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    private String id;

    @Column(name = "rating")
    private String rating;

    @Column(name = "msg")
    private String msg;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(
            name = "restaurant_id",
            nullable = false
    )
    @JsonBackReference // the child
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    @JsonBackReference
    private User user;

    public Review() {
        super();
    }

    public Review(String id, String rating, String msg, String username) {
        this.id = id;
        this.rating = rating;
        this.msg = msg;
        this.username = username;
    }

    public Review(String id, String rating, String msg, String username, Restaurant restaurant, User user) {
        this.id = id;
        this.rating = rating;
        this.msg = msg;
        this.username = username;
        this.restaurant = restaurant;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", rating='" + rating + '\'' +
                ", msg='" + msg + '\'' +
                ", username='" + username + '\'' +
                ", restaurant=" + restaurant +
                ", user=" + user +
                '}';
    }
}
