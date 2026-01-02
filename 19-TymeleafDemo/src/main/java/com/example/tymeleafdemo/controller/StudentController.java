package com.example.tymeleafdemo.controller;


import com.example.tymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {



    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        Student theStudent=new Student();

        theModel.addAttribute("student",theStudent);



        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        System.out.println("The Student: "+theStudent.getFirstName()+ " "+theStudent.getLastName()) ;

        return "student-confirmation";
    }
}
