package com.in28minutes.springbootjpa;

import com.in28minutes.springbootjpa.entity.Course;
import com.in28minutes.springbootjpa.entity.Review;
import com.in28minutes.springbootjpa.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class PerformanTest {
    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void shouldFindCourseById() {
        List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class).getResultList();
        for (Course course: courses) {
            log.info("Course -> {} Students -> {}", course, course.getStudents());
        }
    }

    @Test
    @Transactional
    void shouldFindCourseById_EntityGraph() {
        EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
        Subgraph<Object> subGraph = entityGraph.addSubgraph("students");
        List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class)
                .setHint("javax.persistence.loadgraph", entityGraph)
                .getResultList();
        for (Course course: courses) {
            log.info("Course -> {} Students -> {}", course, course.getStudents());
        }
    }

    @Test
    @Transactional
    void shouldFindCourseById_JoinFetch() {
        List<Course> courses = em.createNamedQuery("query_get_all_courses_join_fetch", Course.class)
                .getResultList();
        for (Course course: courses) {
            log.info("Course -> {} Students -> {}", course, course.getStudents());
        }
    }
}
