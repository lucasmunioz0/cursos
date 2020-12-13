package com.in28minutes.springbootjpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "passports")
@Data
public class Passport {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String number;

    public Passport(String number) {
        this.number = number;
    }

    public Passport() {
    }
}
