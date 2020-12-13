package com.in28minutes.springbootjpa.repository;

import com.in28minutes.springbootjpa.entity.Passport;
import com.in28minutes.springbootjpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class StudentRepository {
    @Autowired
    EntityManager em;

    public Student findById(Long id){
        return em.find(Student.class, id);
    }

    @Transactional
    public Student save(Student student){
        if(student.getId() == null || student.getId() == 0){
            em.persist(student);;
        }else{
            em.merge(student);
        }

        return student;
    }

    @Transactional
    public void deleteById(Long id){
        em.remove(findById(id));
    }

    @Transactional
    public void saveStudentWithPassport(){
        Student student = new Student("Lucas Muñoz");
        Passport passport = new Passport("Z12345");
        em.persist(passport);
        student.setPassport(passport);
        em.persist(student);
    }
}
