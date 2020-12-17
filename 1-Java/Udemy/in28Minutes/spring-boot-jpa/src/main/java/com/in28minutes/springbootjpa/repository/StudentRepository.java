package com.in28minutes.springbootjpa.repository;

import com.in28minutes.springbootjpa.entity.Course;
import com.in28minutes.springbootjpa.entity.Passport;
import com.in28minutes.springbootjpa.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
@Slf4j
public class StudentRepository {
    @Autowired
    EntityManager em;

    public Student findById(Long id){
        return em.find(Student.class, id);
    }


    public Student save(Student student){
        if(student.getId() == null || student.getId() == 0){
            em.persist(student);;
        }else{
            em.merge(student);
        }

        return student;
    }

    public void deleteById(Long id){
        em.remove(findById(id));
    }

    public void saveStudentWithPassport(){
        Student student = new Student("Lucas Muñoz");
        Passport passport = new Passport("Z12345");
        em.persist(passport);
        student.setPassport(passport);
        em.persist(student);
    }

    public void insertStudentAndCourse(){
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 200 Steps");
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);

        em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course){
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);

        em.persist(student);
    }
}
