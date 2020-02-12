/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raulgpena.application.controller;

import com.raulgpena.application.model.Adress;
import com.raulgpena.application.model.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import org.springframework.validation.annotation.Validated;
@RequestMapping("students")
@RestController
public class StudentController {

    private List<Student> students;
    public StudentController() {
        students = new ArrayList<>();
        students.add(new Student("Lucas", 25, "lucas@hotmail.com", new Adress("San Juan", 1549)));
        students.add(new Student("Pedro", 40, "pedro@hotmail.com", new Adress("Saavedra", 156)));
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get(){
        return ResponseEntity.ok(this.students);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Integer code){
        Student s = this.students.get(code);
        
        s.setAdress(new Adress("Cordoba", 1173));
        
        return ResponseEntity.ok(this.students.get(code));
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated Student student){
//        System.out.println("**********************************************************");
//        System.out.println("NAME ==> ".concat (student.getName()));
//        System.out.println("**********************************************************");
//        if(isEmpty(student.getPassport())){
//            return ResponseEntity.status(404).body("Passport not found");
//        }

        

        return ResponseEntity.noContent().build();
    }
}
