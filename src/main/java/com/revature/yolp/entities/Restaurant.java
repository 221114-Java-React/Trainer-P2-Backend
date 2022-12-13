package com.revature.yolp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "img", nullable = false)
    private String img;

    @OneToMany(
            mappedBy = "restaurant",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Review> reviews;

    public Restaurant() {
        super();
    }

    public Restaurant(String id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public Restaurant(String id, String name, String img, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.reviews = reviews;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
