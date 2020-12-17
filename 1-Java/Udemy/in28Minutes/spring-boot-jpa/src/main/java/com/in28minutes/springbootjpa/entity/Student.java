package com.in28minutes.springbootjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "ID_STUDENT"), inverseJoinColumns = @JoinColumn(name = "ID_COURSE"))
    private List<Course> courses;

    public Student(String name) {
        this();
        this.name = name;
    }

    public Student() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }
}
