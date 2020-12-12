package com.in28minutes.springbootjpa;

import com.in28minutes.springbootjpa.entity.Course;
import com.in28minutes.springbootjpa.repository.CourseRepository;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CourseTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void shouldFindCourseById() {
        Course course = courseRepository.findById(10001L);
        assertTrue(course.getId().equals(10001L) && course.getName().equals("JPA in 50 Steps"));
    }

    @Test
    @DirtiesContext
    void shouldDeleteCourseById(){
        courseRepository.deleteById(10002L);
        assertNull(courseRepository.findById(10002L));
    }

    @Test
    void shouldInsertNewCourse(){
        Course course = new Course("Microservices in 100 Steps");
        courseRepository.save(course);
        assertTrue(course.getId() > 0);
    }

    @Test
    void shouldUpdateCourse(){
        Course course = courseRepository.findById(10001L);
        course.setName("New Name");
        courseRepository.save(course);
        course = courseRepository.findById(10001L);
        assertTrue("New Name".equals(course.getName()));
    }

}
