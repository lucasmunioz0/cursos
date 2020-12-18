package com.in28minutes.springbootjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@NamedQueries(
        value = {
                @NamedQuery(name="query_get_all_courses", query = "SELECT c FROM Course c"),
                @NamedQuery(name="query_get_all_courses_join_fetch", query = "SELECT c FROM Course c JOIN FETCH c.students s"),
                @NamedQuery(name="query_get_all_courses_100_steps", query = "SELECT c FROM Course c WHERE c.name like '%100 Steps'")
        }
)

@Data
@Cacheable
@SQLDelete(sql = "update courses set is_deleted=true where id=?")
@Where(clause = "is_deleted = false")
@Slf4j
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "course")
    private List<Review> reviews;
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students;
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;
    @CreationTimestamp
    private LocalDateTime createdDate;
    private boolean isDeleted;

    @PreRemove
    private void preRemove(){
        log.info("Borrando entity");
        this.isDeleted = true;
    }

    public Course() {
        reviews = new ArrayList<>(); students = new ArrayList<>();
    }

    public Course(String name) {
        this();
        this.name = name;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void removeReview(Review review){
        this.reviews.remove(review);
    }
    public void addStudent(Student student){
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    @Override
    public String toString() {
        return "\nCourse{" +
                "name='" + name + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
