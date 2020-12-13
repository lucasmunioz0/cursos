package com.in28minutes.springbootjpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }
}
