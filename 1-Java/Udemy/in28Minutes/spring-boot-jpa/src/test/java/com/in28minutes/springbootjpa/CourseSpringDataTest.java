package com.in28minutes.springbootjpa;

import com.in28minutes.springbootjpa.entity.Course;
import com.in28minutes.springbootjpa.entity.Review;
import com.in28minutes.springbootjpa.repository.CourseRepository;
import com.in28minutes.springbootjpa.repository.CourseSpringDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class CourseSpringDataTest {

    @Autowired
    private CourseSpringDataRepository courseRepository;
    @Autowired
    private EntityManager em;

    @Test
    void shouldFindCourseById() {
        Course course = courseRepository.findById(10001L).orElse(null);
        log.info("Course -> {}", course);
    }

    @Test
    void playingAroundWithSpringDataRepository() {
        log.info("Courses -> {}", courseRepository.findAll());
//        log.info("Courses Length-> {}", courseRepository.count());
    }
    @Test
    void shouldGetAllCoursesByOrder() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        log.info("Sorted Courses -> {}", courseRepository.findAll(sort));
//        log.info("Courses Length-> {}", courseRepository.count());
    }

    @Test
    void pagination() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        PageRequest pageRequest = PageRequest.of(0, 3, sort);
        Page<Course> firstPage = courseRepository.findAll(pageRequest);
        log.info("First Page -> {}", firstPage.getContent());

        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = courseRepository.findAll(secondPageable);
        log.info("Second Page -> {}", secondPage.getContent());
    }

    @Test
    void findByName() {
        List<Course> dummies = courseRepository.findByNameLike("Dummy");
        log.info("Find by Name -> {}", dummies);
    }
}
