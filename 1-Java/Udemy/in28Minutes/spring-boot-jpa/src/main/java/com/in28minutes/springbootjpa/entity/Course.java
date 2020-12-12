package com.in28minutes.springbootjpa.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
@NamedQueries(
        value = {
                @NamedQuery(name="query_get_all_courses", query = "SELECT c FROM Course c"),
                @NamedQuery(name="query_get_all_courses_100_steps", query = "SELECT c FROM Course c WHERE c.name like '%100 Steps'")
        }
)

@Data
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }
}
