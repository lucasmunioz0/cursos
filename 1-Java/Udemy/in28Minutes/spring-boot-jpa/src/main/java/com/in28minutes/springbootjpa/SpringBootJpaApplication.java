package com.in28minutes.springbootjpa;

import com.in28minutes.springbootjpa.entity.*;
import com.in28minutes.springbootjpa.repository.CourseRepository;
import com.in28minutes.springbootjpa.repository.EmployeeRepository;
import com.in28minutes.springbootjpa.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringBootJpaApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //studentRepository.saveStudentWithPassport();
//        List<Review> reviews = Arrays.asList(
//                new Review("5", "This is Awesome"),
//                new Review("5", "This is good")
//        );
//        courseRepository.addReviewsForCourse(10001L, reviews);
//        studentRepository.insertStudentAndCourse(new Student("Lucas"), new Course("TestCourse"));
//        employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
//        employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//        List<Employee> fullTimeEmployess = employeeRepository.findAllFullTimeEmployess();
//        List<Employee> partTimeEmployess = employeeRepository.findAllPartTimeEmployess();
//        log.info("Employess -> {}", fullTimeEmployess);
//        log.info("Employess -> {}", partTimeEmployess);
    }
}
