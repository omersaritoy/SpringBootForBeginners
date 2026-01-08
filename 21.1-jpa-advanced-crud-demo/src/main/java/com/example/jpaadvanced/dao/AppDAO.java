package com.example.jpaadvanced.dao;

import com.example.jpaadvanced.entity.Instructor;
import com.example.jpaadvanced.entity.InstructorDetail;
import org.springframework.stereotype.Repository;


public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);

}
