package com.in28minutes.springbootjpa;

import com.in28minutes.springbootjpa.entity.Course;
import com.in28minutes.springbootjpa.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest(classes = SpringBootJpaApplication.class)
@Slf4j
public class CriteriaTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EntityManager em;

    @Test
    void shouldFindAllCourses() {
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cBuilder.createQuery(Course.class);
        Root<Course> root = cq.from(Course.class);
        TypedQuery<Course> query = em.createQuery(cq.select(root));
        List<Course> resultList = query.getResultList();

        log.info("All courses -> {}", resultList);
    }

    @Test
    void shouldFindAllCourses100Steps() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> root = cq.from(Course.class);
        Predicate like = cb.like(root.get("name"), "%100 Step%");
        cq.where(like);
        TypedQuery<Course> query = em.createQuery(cq.select(root));

        List<Course> resultList = query.getResultList();

        log.info("All courses -> {}", resultList);
    }

    @Test
    void shouldFindAllCoursesWithoutStudents() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> root = cq.from(Course.class);
        Predicate like = cb.isEmpty(root.get("students"));
        cq.where(like);
        TypedQuery<Course> query = em.createQuery(cq.select(root));

        List<Course> resultList = query.getResultList();

        log.info("All courses -> {}", resultList);
    }

    @Test
    void join() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> root = cq.from(Course.class);
        Join<Object, Object> students = root.join("students");


        TypedQuery<Course> query = em.createQuery(cq.select(root));

        List<Course> resultList = query.getResultList();

        log.info("All courses -> {}", resultList);
    }

    @Test
    void left_join() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> root = cq.from(Course.class);
        Join<Object, Object> students = root.join("students", JoinType.LEFT);


        TypedQuery<Course> query = em.createQuery(cq.select(root));

        List<Course> resultList = query.getResultList();

        log.info("All courses -> {}", resultList);
    }
}