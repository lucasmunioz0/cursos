package com.educacionit.java.web;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static List<Student> students;
    
    static{
        students = new ArrayList<>();
    }
    
    public List<Student> findAll(){
        return students;
    }
    
    public List<Student> findByName(String name){
        List<Student> result = new ArrayList<>();
        students.forEach(student -> {
            if(student.getFirstName().equalsIgnoreCase(name)) result.add(student);
        });
        return result;
    }
    
    public Student findById(Integer id){
        Student result = null;
        
        for (Student student : students) {
            if(student.getId() == id) result = student;
        }
        
        return result;
    }
    
    public Student save(Student student){
        return student.getId() == null || student.getId() == 0? create(student) : update(student);
    }
    
    public Student create(Student student){
        student.setId(students.size());
        students.add(student);
        
        return student;
    }
    
    public Student update(Student upStudent){        
        for (Student student : students) {
            if(student.getId() == upStudent.getId()) student = upStudent;
        }
        
        return upStudent;
    }
    
    public boolean remote(Student upStudent){
        for (Student student : students) {
            if(student.getId() == upStudent.getId()) {
                students.remove(student);
                return true;
            }
        }
        
        return false;
    }
}