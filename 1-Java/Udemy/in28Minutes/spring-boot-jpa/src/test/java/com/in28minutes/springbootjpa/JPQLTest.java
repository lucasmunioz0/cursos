package com.in28minutes.springbootjpa;

import com.in28minutes.springbootjpa.entity.Course;
import com.in28minutes.springbootjpa.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class JPQLTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EntityManager em;

    @Test
    void shouldFindAllCourses() {
        List<Course> courses = em.createQuery("Select c FROM Course c", Course.class).getResultList();
        log.info("All courses -> {}", courses);
        assertTrue(courses.size() == 3);
    }

    @Test
    void shouldFindAllCourses_typed() {
        TypedQuery<Course> query = em.createQuery("Select c FROM Course c", Course.class);
        List<Course> courses = query.getResultList();
        log.info("All courses -> {}", courses);
        assertTrue(courses.size() == 3);
    }

    @Test
    void shouldFilterCourses(){
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses_100_steps", Course.class);
        List<Course> courses = query.getResultList();
        log.info("All courses -> {}", courses);
        assertTrue(courses.size() == 2);
    }
}
