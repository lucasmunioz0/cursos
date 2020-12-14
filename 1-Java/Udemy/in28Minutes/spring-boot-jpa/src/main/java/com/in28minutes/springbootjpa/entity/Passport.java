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
    @OneToOne(mappedBy = "passport", fetch = FetchType.LAZY)
    private Student student;

    public Passport(String number) {
        this.number = number;
    }

    public Passport() {
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '}';
    }
}
