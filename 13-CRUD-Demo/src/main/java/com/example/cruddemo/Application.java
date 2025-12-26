package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;

import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDao) {

        return runner ->
        {
//            createStudent(studentDao);
//            createMultipleStudents(studentDao);
//            readStudentDAO(studentDao);
//
//            queryForStudents(studentDao);

//            queryForStudentsByLastName(studentDao);

            updateStudent(studentDao);


        };
    }

    private void updateStudent(StudentDAO studentDao) {
        int studentId=1;
        System.out.println("Getting student with id :" +studentId);

        Student myStudent=studentDao.findById(studentId);

        System.out.println("Updating  student ...");

        myStudent.setFirstName("Scooby");
        studentDao.update(myStudent);

        System.out.println("updated student: "+myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDao) {
        List<Student> theStudents=studentDao.findByLastName("Doe");

        for(Student student:theStudents)
            System.out.println(student.toString());
    }

    private void queryForStudents(StudentDAO studentDao) {
        List<Student> theStudents = studentDao.findAll();

        for (Student student : theStudents)
            System.out.println(student.toString());
    }

    private void readStudentDAO(StudentDAO studentDao) {

        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Omer", "Saritoy", "omer.saritoy@test.com");

        System.out.println("Student Saving ...");
        studentDao.save(tempStudent);

        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id:" + theId);

        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDao.findById(theId);

        System.out.println("Found the student: " + myStudent);

    }

    private void createMultipleStudents(StudentDAO studentDao) {
        System.out.println("Creating new students object ...");
        Student tempStudent1 = new Student("Jack", "Doe", "Jack@test.com");

        Student tempStudent2 = new Student("Carl", "Doe", "Carl@test.com");

        Student tempStudent3 = new Student("John", "Doe", "John@test.com");

        Student tempStudent4 = new Student("Mia", "Doe", "Mia@test.com");

        System.out.println("Saving the students...");
        studentDao.save(tempStudent1);
        studentDao.save(tempStudent2);
        studentDao.save(tempStudent3);
        studentDao.save(tempStudent4);


    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Paul", "Doe", "paul@test.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

}
