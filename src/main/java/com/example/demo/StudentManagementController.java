package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents(){
        return STUDENTS;
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student);
    }
    @DeleteMapping(path ="{studentId}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void deleteStudent(@PathVariable Integer id){
        System.out.println(id);
    }

}
