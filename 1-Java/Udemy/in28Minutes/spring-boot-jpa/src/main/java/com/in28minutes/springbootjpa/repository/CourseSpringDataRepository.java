package com.in28minutes.springbootjpa.repository;

import com.in28minutes.springbootjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameAndId(String name, Long id);
    List<Course> findByName(String name);
    List<Course> countByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);
    List<Course> deleteByName(String name);
    @Query(value = "SELECT c FROM Course c WHERE c.name like %:name%")
    List<Course> findByNameLike(String name);
}
