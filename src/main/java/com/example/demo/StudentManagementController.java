package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("managenent/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "student1"),
            new Student(2, "student2"),
            new Student(3, "student3")
    );
    public List<Student> getAllStudents(){
        return STUDENTS
    }
    public void registerNewStudent(Student student){
        System.out.println(student);
    }
    public void deleteStudent(Integer id){
        System.out.println(id);
    }

}
