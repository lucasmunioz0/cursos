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
    @Enumerated(value = EnumType.STRING)
    private ReviewRating rating;
    private String description;
    @ManyToOne
    private Course course;

    public Review(ReviewRating rating, String description) {
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
