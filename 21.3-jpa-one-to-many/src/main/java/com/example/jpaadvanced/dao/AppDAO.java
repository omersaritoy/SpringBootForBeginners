package com.example.jpaadvanced.dao;

import com.example.jpaadvanced.entity.Course;
import com.example.jpaadvanced.entity.Instructor;
import com.example.jpaadvanced.entity.InstructorDetail;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    Course findCourseById(int theId);

    void update(Course tempCourse);

    void deleteCourseById(int theId);

    void save(Course thCourse);

    Course findCourseAndReviewsByCourseId(int theId);



}
