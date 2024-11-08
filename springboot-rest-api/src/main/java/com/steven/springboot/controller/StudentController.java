package com.steven.springboot.controller;


import com.steven.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1, "Steven", "Huynh");
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @GetMapping("/students")
    public List<Student> getStudentList(){
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student(1, "Steven", "Huynh");
        Student student2 = new Student(2, "Michael", "Ballack");
        Student student3 = new Student(3, "Leo", "Messi");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        return studentList;
    }

    @GetMapping("/student/{id}/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable int id, @PathVariable String firstName,
                                       @PathVariable String lastName){

        Student student = new Student(id, firstName, lastName);
        return student;
    }


    // http://localhost:8080/students/query?id=1&firstName=steven&lastName=Huynh
    @GetMapping("/students/query")
    public Student studentRequestParam(@RequestParam int id,
                                       @RequestParam String firstName,
                                       @RequestParam String lastName){

        Student student = new Student(id, firstName, lastName);
        return student;
    }


    // Spring Boot REST API POST request
    // @PostMapping + @RequestBody
    @PostMapping("/student")
    public Student postRequest(@RequestBody Student student){

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @PutMapping("/student/{id}/update")
    public Student updateStudent(@PathVariable int id,
                                 @RequestBody Student student){

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

    @DeleteMapping("student/{id}/delete")
    public String deleteStudent(@PathVariable int id){

        return "delete ok";
    }

}
