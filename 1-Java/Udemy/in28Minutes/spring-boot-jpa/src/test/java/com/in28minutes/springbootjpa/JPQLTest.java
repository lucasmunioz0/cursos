package com.in28minutes.springbootjpa;

import com.in28minutes.springbootjpa.entity.Course;
import com.in28minutes.springbootjpa.entity.Student;
import com.in28minutes.springbootjpa.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

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

    @Test
    void coursesWithoutStudents(){
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c where c.students is empty", Course.class);
        List<Course> courses = query.getResultList();
        log.info("All courses -> {}", courses);
    }

    @Test
    void coursesWithAtLeast2Students(){
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c where size(c.students) >= 2", Course.class);
        List<Course> courses = query.getResultList();
        log.info("All courses -> {}", courses);
    }

    @Test
    void coursesWithAtLeast2StudentsOrdered(){
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c order by size(c.students)", Course.class);
        List<Course> courses = query.getResultList();
        log.info("All courses -> {}", courses);
    }

    @Test
    @Transactional
    void studentsWithLike(){
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s where s.passport.number like '%1234%'", Student.class);
        List<Student> students = query.getResultList();
        log.info("All students -> {}", students);
    }

    @Test
    @Transactional
    void left_join(){
        Query query = em.createQuery("SELECT c, s FROM Course c LEFT JOIN c.students s");
        List<Object[]> students = query.getResultList();
        log.info("Courses -> {}", students);
        for (Object[] result :  students) {
            log.info("Course: {} \nStudent: {}", result[0], result[1]);
        }
    }

    @Test
    @Transactional
    void join(){
        Query query = em.createQuery("SELECT c, s FROM Course c JOIN c.students s");
        List<Object[]> students = query.getResultList();
        log.info("Courses -> {}", students);
        for (Object[] result :  students) {
            log.info("Course: {} \nStudent: {}", result[0], result[1]);
        }
    }

    @Test
    @Transactional
    void cross_join(){
        Query query = em.createQuery("SELECT c, s FROM Course c, Student s");
        List<Object[]> students = query.getResultList();
        log.info("Courses -> {}", students);
        for (Object[] result :  students) {
            log.info("Course: {} \nStudent: {}", result[0], result[1]);
        }
    }
}
