package com.in28minutes.springbootjpa;

import com.in28minutes.springbootjpa.entity.Passport;
import com.in28minutes.springbootjpa.entity.Student;
import com.in28minutes.springbootjpa.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails(){
        Student student = em.find(Student.class, 2L);
        log.info("Student -> ", student.toString());
        log.info("Student -> {}", student.getPassport().toString());
    }

    @Test
    @Transactional
    public void someTest(){
        Student student = em.find(Student.class, 2001L);
        Passport passport = student.getPassport();
        passport.setNumber("E1234567");
        student.setName(student.getName() + " - updated");
    }

}
