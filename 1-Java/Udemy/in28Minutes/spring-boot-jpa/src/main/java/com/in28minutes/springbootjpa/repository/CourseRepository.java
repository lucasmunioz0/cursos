package com.in28minutes.springbootjpa.repository;

import com.in28minutes.springbootjpa.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class CourseRepository {
    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    @Transactional
    public Course save(Course course){
        if(course.getId() == null || course.getId() == 0){
            em.persist(course);;
        }else{
            em.merge(course);
        }

        return course;
    }

    @Transactional
    public void deleteById(Long id){
        em.remove(findById(id));
    }

    @Transactional
    public void playWithEntityManager(){
        Course course = new Course("Microservices in 100 Steps");
        em.persist(course);

        Course course2 = findById(10001L);
        course2.setName(course.getName() + " updated");
        em.merge(course2);
    }
}
