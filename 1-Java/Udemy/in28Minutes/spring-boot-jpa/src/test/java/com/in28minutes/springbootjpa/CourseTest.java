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

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class CourseTest {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EntityManager em;

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

    @Test
    @Transactional
    void retrieveReviewForCourse(){
        Course course = courseRepository.findById(10001L);
        log.info("{}", course.getReviews());
    }

    @Test
    @Transactional(isolation = Isolation.READ_COMMITTED)
    void retrieveReviewForReview(){
        Review review = em.find(Review.class, 50001L);
        log.info("{}", review.getCourse());
    }

}
