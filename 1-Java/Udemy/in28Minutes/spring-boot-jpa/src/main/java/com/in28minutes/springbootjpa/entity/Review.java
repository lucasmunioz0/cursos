package com.in28minutes.springbootjpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String rating;
    private String description;

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Review() {
    }
}
