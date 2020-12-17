package com.in28minutes.springbootjpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String rating;
    private String description;
    @ManyToOne
    private Course course;

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Review() {
    }

    @Override
    public String toString() {
        return "Review{" +
                "rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
