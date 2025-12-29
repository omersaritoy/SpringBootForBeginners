package com.example.springbootrestcrud.controller;


import com.example.springbootrestcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents=new ArrayList<>();
        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Maria", "Rossie"));
        theStudents.add(new Student("Marry", "Smith"));
        theStudents.add(new Student("John", "Doe"));
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studendId}")
    public Student getStudent(@PathVariable int studendId){
        if(studendId>=theStudents.size()||studendId<0)
            throw new StudentNotFoundException("Studen id not found-"+studendId);


        return theStudents.get(studendId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());


        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
