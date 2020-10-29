package com.sga.web;

import com.sga.domain.Student;
import com.sga.services.StudentService;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentController extends HttpServlet {

    private StudentService service;

    public StudentController() {
        service = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            Long id = Long.parseLong(idStr);
            Student student = service.getById(id);
            System.out.println(student);
            request.setAttribute("student", student);
            request.getRequestDispatcher("/WEB-INF/student/student.jsp").forward(request, response);
        } else {
            List<Student> students = service.getAll();
            request.setAttribute("students", students);
            request.getRequestDispatcher("/WEB-INF/student/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Enumeration<String> params = request.getParameterNames();
        
        if(request.getParameter("action").equals("Save")){
            
        }else{
            String idStr = request.getParameter("id");
            Long id = Long.parseLong(idStr);
            service.delete(new Student(id));
            response.sendRedirect("students");
//            request.getRequestDispatcher("/WEB-INF/student/list.jsp");
//            request.
        }

//        while(params.hasMoreElements()){
//            String element = params.nextElement();
//            System.out.println("Param: " + element + " - Value: " + request.getParameter(element));
//        }
    }
}
