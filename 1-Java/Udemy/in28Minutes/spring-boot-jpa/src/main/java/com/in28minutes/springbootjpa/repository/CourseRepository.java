package com.in28minutes.springbootjpa.repository;

import com.in28minutes.springbootjpa.entity.Course;
import com.in28minutes.springbootjpa.entity.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Slf4j
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public Course save(Course course){
        if(course.getId() == null || course.getId() == 0){
            em.persist(course);;
        }else{
            em.merge(course);
        }

        return course;
    }

    public void deleteById(Long id){
        em.remove(findById(id));
    }

    public void playWithEntityManager(){
        Course course = new Course("Microservices in 100 Steps");
        em.persist(course);

        Course course2 = findById(10001L);
        course2.setName(course.getName() + " updated");
        em.merge(course2);
    }

    public void addReviewsForCourse(Long idCourse, List<Review> reviews) {
        Course course = findById(idCourse);
        log.info("Course.getReviews -> {}", course.getReviews());
        reviews.forEach(review -> {
            review.setCourse(course);
            course.addReview(review);
            em.persist(review);
        });
        em.merge(course);
    }
}
