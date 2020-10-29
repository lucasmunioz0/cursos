package com.sga.dal.repositories;

import static com.sga.dal.repositories.BaseRepository.em;
import com.sga.domain.Course;
import java.util.List;
import javax.persistence.Query;

public class CourseRepository extends BaseRepository<Course>{
    @Override
    public List<Course> getAll(){
        Query query = em.createQuery("FROM Course");
        return query.getResultList();
    }
    
    public Course getById(Course course){
        return em.find(Course.class, course.getId());
    }
}
